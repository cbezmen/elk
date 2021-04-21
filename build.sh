#!/bin/bash
projectVersion=v1
projectArray=(sample-app)
elkArray=(elasticsearch kibana logstash)
function note() {
  local GREEN NC
  GREEN='\033[0;32m'
  NC='\033[0m' # No Color
  printf "\n${GREEN}$@  ${NC}\n" >&2
}

set -e


if [[ $@ == *"build-k8"* ]]; then
  note "Building images..."
  for project in ${projectArray[*]}; do
    note "Compiling $project..."
    cd $project; mvn clean install -DskipTest; docker build -f docker/Dockerfile -t $project:$projectVersion .; cd -
  done


  for elk in ${elkArray[*]}; do
    note "Compiling $elk..."
    cd elk/$elk; docker build -f Dockerfile -t $elk:$projectVersion .; cd -
  done

fi


if [[ $@ == *"stop-k8"* ]]; then
  note "Stoping kubernetes..."
  kubectl delete service --all
  kubectl delete deployment --all
  kubectl delete pvc --all
  kubectl delete pv --all
fi

if [[ $@ == *"start-k8"* ]]; then
  note "Starting building yaml files..."
  cd kubernetes; kubectl apply -f .; cd -
fi



if [[ $@ == *"stop-d9"* ]]; then
  note "Stoping docker compose..."
  docker compose down
fi

if [[ $@ == *"start-d9"* ]]; then
  note "Starting docker compose..."
  docker compose up --build -d --scale app=1
fi

