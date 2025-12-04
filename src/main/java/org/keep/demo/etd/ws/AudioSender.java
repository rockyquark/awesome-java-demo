package org.keep.demo.etd.ws;

import lombok.extern.slf4j.Slf4j;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AudioSender {

    private static final int WAV_HEADER = 44;

    public void sendAudioChunks(AsrWebSocketClient client, String filePath, String mode) throws Exception {

        RandomAccessFile raf = new RandomAccessFile(filePath, "r");

        if (filePath.endsWith(".wav")) {
            raf.seek(WAV_HEADER);
        }

        byte[] buf = new byte[16 * 16000]; // 16s @ 16k
        int read;

        while ((read = raf.read(buf)) != -1) {

            byte[] chunk = new byte[read];
            System.arraycopy(buf, 0, chunk, 0, read);

            client.send(chunk);

            // 在线模式需要模拟延时
            if ("online".equals(mode)) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }

        raf.close();
    }
}
