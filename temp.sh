# script to run managed hosts for ansible
docker build -f Dockerfile.managed -t managed-image .

docker run -dt -P --name managed1 managed-image
docker run -dt -P --name managed2 managed-image
