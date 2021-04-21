# **Microservice Logging Example**

- [**Microservice Logging Example**](#microservice-logging-example)
    - [Docker](#docker)
        - [Description](#description)
        - [Start Docker Compose](#start-docker-compose)
        - [Watch Docker Containers](#watch-docker-containers)
        - [Stop Docker Compose](#stop-docker-compose)
    - [Kubernetes](#kubernetes)
        - [Description](#description)
        - [Build Projects](#build-projects)
        - [Start Kubernetes](#start-kubernetes)
        - [Watch Kubernetes Environment](#watch-kubernetes-environment)
        - [Stop Kubernetes](#stop-kubernetes)
    - [Knowledge & Requirements](#knowledge-requirements)
        - [Cli Versions](#cli-versions)

## Docker

### Description

Docker compose for fast build. docker-compose command required for this build.

### Start Docker Compose

```
$ ./build.sh start-d9
```

This command start `docker-compose.yaml` file. This will run sample-app and elk projects.

You can check Kibana UI from http://localhost:5601/app/kibana

### Watch Docker Containers

```
$ watch docker ps
```

With this command, you can easily watch all containers created.

### Stop Docker Compose

```
$ ./build.sh stop-d9
```

This command stop docker-compose file and remove `containers`.

## Kubernetes

### Description

I used docker desktop kubernetes

For elastic search you have to increase memory, from configuration CPU: 6 Memory: 6GB is enough

### Build Projects

```
$ ./build.sh build-k8
```

This command build and dockerized all projects under minikube environment.

> **Warning**:  There is no support for relative path in kubernetes. Please change `hostPath` field in `logstash.yml` and `kibana.yml` !!!

### Start Kubernetes

```
$ ./build.sh start-k8
```

This command run `kubectl create -f .` command under kubernetes folder. This will create services and deployments of sample-app and elk projects.

You can check Kibana UI from in http://localhost:5601/

### Watch Kubernetes Environment

```
$ watch kubectl get all
```

With this command, you can easily watch all deployments, service, pods, persistent volume and claim.

### Stop Kubernetes

```
$ ./build.sh stop-k8
```

This command stop all `services` and `deployments` created.

## Knowledge & Requirements

* [Spring](https://spring.io/)
    * [Spring Boot](https://projects.spring.io/spring-boot/)
* [LOG](https://www.slf4j.org/manual.html)
    * [Logback JSON Encoder](https://github.com/logstash/logstash-logback-encoder)
* [Gradle](https://gradle.org/)
* [Docker](https://www.docker.com/)
    * [Docker Tutorial](https://docs.docker.com/get-started/#setup)
    * [Docker File](https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/#label)
* [Kubernetes](https://kubernetes.io/)
    * [Docker desktop kubernetes](https://docs.docker.com/desktop/kubernetes/)
* [Project Lombok](https://projectlombok.org/)

### Cli Versions

|            Cli            | Version |
| :-----------------------: | :-----: |
|          docker           | 20.10.5 |
| docker desktop kubernetes | v1.19.7 |
|            mvn            |  3.8.1  |

![Deadline gif](images/giphy.gif)
