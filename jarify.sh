javac -cp "/Users/iOS_Coder/Hadoop_Test:/usr/local/Cellar/hadoop/2.7.2/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.2.jar:/usr/local/Cellar/hadoop/2.7.2/libexec/share/hadoop/common/hadoop-common-2.7.2.jar" *.java
jar cfm sub/MyJob.jar Manifest.txt *.class
