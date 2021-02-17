docker build -f Dockerfile.test -t calculator-test .
docker run -i calculator-test:latest
