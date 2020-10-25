#!/bin/sh

docker-compose -p "taskmanager-dev" -f docker-compose-db.yml up -d --build
