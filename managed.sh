# script to run managed hosts for ansible
docker rm -f $(docker ps -a | grep managed | awk '{print $1}' )
docker build -f Dockerfile.managed -t managed-image .

docker run -v /var/run/docker.sock:/var/run/docker.sock -dt -P --name managed1 managed-image
docker run -v /var/run/docker.sock:/var/run/docker.sock -dt -P --name managed2 managed-image
