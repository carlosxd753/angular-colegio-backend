#!/bin/bash

payload=$1

if echo "$payload" | grep -q '"ref":"refs/heads/main"'; then
  echo "Push a main detectado. Ejecutando deploy..."
else
  echo "Webhook recibido pero no es push a main"
  exit 0
fi

cd /home/root/colegio
git pull
export HOME=/root
chmod +x mvnw
./mvnw clean package -DskipTests
if [ $? -ne 0 ]; then
  echo "ERROR: Fallo la compilacion"
  exit 1
fi
docker compose down
docker compose up -d --build --force-recreate
docker image prune -f