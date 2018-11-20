# SparkAtlasDemo

```
=== Working ====

/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode client --conf spark.sql.queryExecutionListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.extraListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.sql.streaming.streamingQueryListeners=com.hortonworks.spark.atlas.SparkAtlasStreamingQueryEventTracker --conf spark.executor.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --conf spark.driver.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --class com.hortonworks.spark.demo.SparkHiveExample  --name SparkHiveExample --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 --jars /tmp/spark-atlas-connector-assembly_2.11-0.1.0-SNAPSHOT.jar --principal spark-hcegchdp1@ADS.AZURE.HORTONWORKS.COM --keytab /etc/security/keytabs/spark.headless.keytab --files /tmp/jaas.conf /home/cloudbreak/SparkAtlasDemo-1.0-SNAPSHOT.jar

/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode client --conf spark.sql.queryExecutionListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.extraListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.sql.streaming.streamingQueryListeners=com.hortonworks.spark.atlas.SparkAtlasStreamingQueryEventTracker --conf spark.executor.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --conf spark.driver.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --class com.hortonworks.spark.demo.SparkMLExample  --name SparkMLExample --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 --jars /tmp/spark-atlas-connector-assembly_2.11-0.1.0-SNAPSHOT.jar --principal spark-hcegchdp1@ADS.AZURE.HORTONWORKS.COM --keytab /etc/security/keytabs/spark.headless.keytab --files /tmp/jaas.conf /home/cloudbreak/SparkAtlasDemo-1.0-SNAPSHOT.jar


/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode client --conf spark.sql.queryExecutionListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.extraListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.sql.streaming.streamingQueryListeners=com.hortonworks.spark.atlas.SparkAtlasStreamingQueryEventTracker --conf spark.executor.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --conf spark.driver.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --class com.hortonworks.spark.demo.SparkStructuredStreamingExample  --name SparkStructuredStreamingExample --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 --jars /tmp/spark-atlas-connector-assembly_2.11-0.1.0-SNAPSHOT.jar --principal spark-hcegchdp1@ADS.AZURE.HORTONWORKS.COM --keytab /etc/security/keytabs/spark.headless.keytab --files /tmp/jaas.conf /home/cloudbreak/SparkAtlasDemo-1.0-SNAPSHOT.jar


---WORKING ---

-----EXPERIMENT ----

/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode cluster --conf spark.sql.queryExecutionListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.extraListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.sql.streaming.streamingQueryListeners=com.hortonworks.spark.atlas.SparkAtlasStreamingQueryEventTracker --conf spark.executor.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --conf spark.driver.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --class com.hortonworks.spark.demo.SparkHiveExample  --name disSparkHiveExample --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 --jars /tmp/spark-atlas-connector-assembly_2.11-0.1.0-SNAPSHOT.jar --principal spark-hcegchdp1@ADS.AZURE.HORTONWORKS.COM --keytab /etc/security/keytabs/spark.headless.keytab --files /tmp/jaas.conf,/etc/spark2/conf/atlas-application.properties,/etc/spark2/conf/ssl-client.xml  /home/cloudbreak/SparkAtlasDemo-1.0-SNAPSHOT.jar


/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode cluster --conf spark.sql.queryExecutionListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.extraListeners=com.hortonworks.spark.atlas.SparkAtlasEventTracker --conf spark.sql.streaming.streamingQueryListeners=com.hortonworks.spark.atlas.SparkAtlasStreamingQueryEventTracker --conf spark.executor.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --conf spark.driver.extraJavaOptions=-Djava.security.auth.login.config=/tmp/jaas.conf --class com.hortonworks.spark.demo.SparkMLExample  --name SparkMLExample --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0 --jars /tmp/spark-atlas-connector-assembly_2.11-0.1.0-SNAPSHOT.jar --principal spark-hcegchdp1@ADS.AZURE.HORTONWORKS.COM --keytab /etc/security/keytabs/spark.headless.keytab --files /tmp/jaas.conf,/etc/spark2/conf/atlas-application.properties,/etc/spark2/conf/ssl-client.xml /home/cloudbreak/SparkAtlasDemo-1.0-SNAPSHOT.jar


-----EXPERIMENT ----

```