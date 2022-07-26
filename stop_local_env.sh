#!/usr/bin/env bash

###
# Остановка окружения нужного для локальной разработки
###

echo -e "\033[0;31mTrying to stop local environment ...\033[0m"

if [[ -z `which docker-compose` ]]; then
    echo "docker-compose not found, abort execution ..."
    exit 1
fi

cd deploy/local
docker-compose stop jukovproject-db

echo -e "\033[0;31mDONE\033[0m"
