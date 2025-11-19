services:
  ${CURRENT_ETCD_NODE}:
    image: bitnami/etcd:${ETCD_VERSION}
    container_name: etcd
    restart: always
    networks:
      - apisix-net
    environment:
      - ETCD_NAME=${CURRENT_ETCD_NODE}
      - ETCD_INITIAL_ADVERTISE_PEER_URLS=http://${CURRENT_ETCD_NODE}:2380
      - ETCD_LISTEN_PEER_URLS=http://0.0.0.0:2380
      - ETCD_ADVERTISE_CLIENT_URLS=http://${CURRENT_ETCD_NODE}:2379
      - ETCD_LISTEN_CLIENT_URLS=http://0.0.0.0:2379
      - ETCD_INITIAL_CLUSTER=${ETCD_INITIAL_CLUSTER}
      - ETCD_INITIAL_CLUSTER_STATE=new
      - ETCD_INITIAL_CLUSTER_TOKEN=${ETCD_INITIAL_CLUSTER_TOKEN}
    ports:
      - "2379:2379"

    ${CURRENT_APISIX_NODE}:
      image: apache/apisix:${APISIX_VERSION}
      container_name: ${CURRENT_APISIX_NODE}
      volumes:
        - ./conf/apisix_config.yaml:/usr/local/apisix/conf/config.yaml:ro
        - ./conf/apisix.yaml:/usr/local/apisix/conf/apisix.yaml:ro
      ports:
        - "9180:9180/tcp"
        - "9080:9080/tcp"
        - "9091:9091/tcp"
        - "9443:9443/tcp"
      depends_on:
        - ${CURRENT_ETCD_NODE}
      networks:
        - apisix-net

networks:
  apisix-net:
    driver: bridge

