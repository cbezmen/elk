# FROM elasticsearch:5
# FROM docker.elastic.co/elasticsearch/elasticsearch:6.0.0
FROM elasticsearch:5.6.4-alpine
ENV ES_JAVA_OPTS="-Des.path.conf=/etc/elasticsearch"
CMD ["-E", "network.host=0.0.0.0", "-E", "discovery.zen.minimum_master_nodes=1"]
