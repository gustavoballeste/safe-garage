docker run -it --name servicediscovery -p 8761:8761 --network host -d safegarage/discovery

docker run -it --name configserver -p 8761:8761 --network host -d safegarage/config

