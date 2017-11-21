# **Microservice Logging Example**

- [**Microservice Logging Example**](#microservice-logging-example)
    - [Docker](#docker)
        - [Description](#description)
        - [Start Docker Compose](#start-docker-compose)
        - [Stop Docker Compose](#stop-docker-compose)
    - [Kubernetes](#kubernetes)
        - [Description](#description)
        - [Build Projects](#build-projects)
        - [Start Kubernetes](#start-kubernetes)
        - [Stop Kubernetes](#stop-kubernetes)
        - [Knowledge & Requirements](#knowledge-requirements)

## Docker

### Description

Docker compose for fast build. docker-compose command required for this build.

### Start Docker Compose

```
./build.sh start-d9
```
This command start `docker-compose.yaml` file. This will run sample-app and elk projects.

### Stop Docker Compose

```
./build.sh stop-d9
```
This command stop docker-compose file and remove `containers`.

## Kubernetes

### Description

Kubernetes for fast build. Minikube required for this build. 

For elastic search you have to increase memory and max map count.

```
minikube delete
minikube config set memory 6144
minikube start
minikube ssh
sudo sysctl -w vm.max_map_count=262144
```
### Build Projects

```
./build.sh build-k8
```
This command build and dockerized all projects under minikube environment.

### Start Kubernetes

```
./build.sh start-k8
```
This  command run `kubectl create -f .` command under kubernetes folder. This will create services and deployments of sample-app and elk projects.

### Stop Kubernetes

```
./build.sh stop-k8
```
This command stop all `services` and `deployments` created.

### Knowledge & Requirements

* [Spring](https://spring.io/)
  * [Spring Boot](https://projects.spring.io/spring-boot/)
* [LOG](https://www.slf4j.org/manual.html)
* [Gradle](https://gradle.org/)
* [Docker](https://www.docker.com/)
  * [Docker Tutorial](https://docs.docker.com/get-started/#setup)
  * [Docker File](https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/#label)
* [Kubernetes](https://kubernetes.io/)  
  * [Minikube](https://kubernetes.io/docs/tutorials/stateless-application/hello-minikube/)
* [Project Lombok](https://projectlombok.org/)
