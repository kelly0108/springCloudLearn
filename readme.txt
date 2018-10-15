在docker中安装rabbitmq
docker search rabbitmq:management
docker pull rabbitmq:management
docker run -d --name myrabbitmq -p 5673:5672 -p 15673:15672 rabbitmq:management