for dir in *-service *-bff configserver servicediscovery ; do
	echo "**************"
	echo "Building >>>>> " $dir
	echo "**************"
	(cd $dir ; ./gradlew clean build)
done
