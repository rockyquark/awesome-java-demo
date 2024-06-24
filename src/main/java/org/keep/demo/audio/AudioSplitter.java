package org.keep.demo.audio;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioSplitter {

    public static void main(String[] args) {
        try {
            File audioFile = new File("C:\\Users\\RockyQuark\\Desktop\\97467599\\97467599_H1.wav");
            splitAudioByDb(audioFile, -30, -15); // 设置分贝区间
        } catch (IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void splitAudioByDb(File audioFile, double minDb, double maxDb)
            throws IOException, UnsupportedAudioFileException {
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(audioFile, 2048, 0);

        dispatcher.addAudioProcessor(new PitchProcessor(PitchEstimationAlgorithm.MPM, 16000, 32000,
                new PitchDetectionHandler() {
                    @Override
                    public void handlePitch(PitchDetectionResult pitchDetectionResult,
                                            AudioEvent audioEvent) {
                        double pitchInHz = pitchDetectionResult.getPitch();
                        double rms = calculateRMS(audioEvent.getFloatBuffer());
                        double db = 20.0 * Math.log10(rms);

                        if (db >= minDb && db <= maxDb) {
                            // 在这里处理符合分贝区间的音频片段

                            System.out.println("Detected speech at time: " + audioEvent.getTimeStamp());
                        }

                    }
                }));

        dispatcher.run();
    }

    private static double calculateRMS(float[] audioBuffer) {
        double sum = 0;
        for (float sample : audioBuffer) {
            sum += sample * sample;
        }
        double rms = Math.sqrt(sum / audioBuffer.length);
        return rms;
    }
}
