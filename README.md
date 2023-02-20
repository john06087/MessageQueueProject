# MessageQueueProject

## 檔案簡介 - introduction

* **Consumer-Demo Project**<br/>
  * **ConsumerApplication.java** -> Consumer 專案啟動檔<br/>
  * **RabbitMqConsumerService.java** -> RabbitMQ Message Listener<br/>
  * **KafkaConsumerService.java** -> Kafka Message Listener<br/>
  * **KafkaConfig.java** -> Kafka 設定檔<br/><br/>
* **Producer-Demo Project**<br/>
  * **ProducerApplication.java** -> Producer 專案啟動檔<br/>
  * **RabbitMqProducerController.java** -> RabbitMQ 功能進入點<br/>
  * **KafkaProducerController.java** -> Kafka 功能進入點<br/>
  * **RabbitMQConfig.java** -> RabbitMQ 設定檔<br/>  
  * **KafkaConfig.java** -> Kafka 設定檔<br/>

## 使用方法 - instruction
> ### RabbitMQ 安裝 (如果已安裝請跳過)
* **安裝 Erlang (RabbitMQ 的執行環境)**
  * **版本對應地址: https://www.rabbitmq.com/which-erlang.html 注意 RabbitMQ 版本對應的 Erlang 版本** <br/>
![image](https://user-images.githubusercontent.com/47651623/218943814-56e62bf8-5823-4625-9e4b-d91e28c1d097.png)
  * **下載地址: https://www.erlang.org/downloads 找到對應的版本進行下載** <br/>
![image](https://user-images.githubusercontent.com/47651623/217975819-f9fd7760-d4b1-4e1f-b0f4-692fa307f2eb.png)
  * **下載完成後直接進行安裝，找到安裝的路徑進行複製 (最後的斜線無須複製)** <br/>
![image](https://user-images.githubusercontent.com/47651623/217976823-19d4fb01-9d3f-4a5d-b7a5-494c9c415d81.png)
  * **安裝完成後，進行環境變數設定，對 "環境變數 -> 系統變數" 點選新增** <br/>
![image](https://user-images.githubusercontent.com/47651623/217977281-b92de9cb-73bf-4abf-a408-6bdf7786c2e4.png)
  * **變數名稱設定: ERLANG_HOME，變數值為剛剛安裝 Erlang 的路徑** <br/>
![image](https://user-images.githubusercontent.com/47651623/217977500-9181d11f-3401-4fa8-a3bd-aa5fa7246c40.png)
  * **設定完成後，選擇系統變數 "Path" 進行編輯** <br/>
![image](https://user-images.githubusercontent.com/47651623/217977787-e3bb0946-99e0-428c-8022-5e24c9b1f07f.png)
  * **點選新增，並打上: %ERLANG_HOME%\bin，按下確定完成編輯** <br/>
![image](https://user-images.githubusercontent.com/47651623/217978022-29afd5c7-39a9-47fb-86c0-8ac15170adf0.png)
  * **開啟 Cmd，輸入: erl，如果出現 erl 的版本，代表安裝成功** <br/>
![image](https://user-images.githubusercontent.com/47651623/217978761-b3dbf05e-51c1-4b1e-9f9a-22420041fda4.png)

<br/>

* **安裝 RabbitMQ**
  * **下載地址: https://www.rabbitmq.com/download.html**<br/>
![image](https://user-images.githubusercontent.com/47651623/218944164-9b1ddddc-0264-43d5-8cd6-2b9d1abba397.png)
  * **安裝過程省略，直接點選下一步即可** <br/>
  * **安裝完成後開啟 Cmd 切換至 RabbitMQ 的 sbin 目錄 (視每個人的安裝目錄不同進行修改)** <br/>
  * **切換好後輸入指令: rabbitmq-plugins enable rabbitmq_management 進行安裝** <br/>
![image](https://user-images.githubusercontent.com/47651623/217979611-451ccd17-6e00-48ee-a590-d828967af0a7.png)
  * **安裝好後再次打開 sbin 目錄，輸入: rabbitmq-server.bat 啟動 RabbitMQ Server** <br/>
  * **輸入 Url: http://localhost:15672 即可進行訪問，帳號密碼皆為: guest** <br/>
![image](https://user-images.githubusercontent.com/47651623/217980839-224727ec-0952-4e6b-bea1-e1f5fd09b2e0.png)
![image](https://user-images.githubusercontent.com/47651623/217980779-f21b46b4-5ef2-4721-acc7-25b8c80e219f.png)
  * **補充: 假設在啟動 rabbitMQ server 時出現以下畫面，並且訪問 rabbitMQ 頁面也無法進入時** <br/>
  * **重新啟動電腦即可** <br/>
![image](https://user-images.githubusercontent.com/47651623/217980344-033be4d6-f014-4683-bc9d-d0e6bc9442ed.png)

---

> ### Kafka 安裝 (如果已安裝請跳過)
* **安裝 Zookeeper**
  * **下載地址: https://zookeeper.apache.org/releases.html**
![image](https://user-images.githubusercontent.com/47651623/218668088-75486517-5bda-4d23-ae29-a4b070bde001.png)
![image](https://user-images.githubusercontent.com/47651623/218668336-ecd95e5d-82a8-41c1-bedf-2291d499af27.png)
  * **下載完成後解壓縮放到自訂路徑**
  * **將 D:\apache-zookeeper-3.7.1-bin\conf 底下的 zoo_sample.cfg 文件更名為 zoo.cfg**
![image](https://user-images.githubusercontent.com/47651623/219850777-28e6f5e8-243b-4895-bbb2-15357fd02ce4.png)
  * **打開 zoo.cfg 找到並編輯 dataDir=D:/apache-zookeeper-3.7.1-bin/tmp**
  * **注意此處配置的路径一定是 "/" 而不是 "\\"，且路徑不可以有空白，否則會啟動失敗**
![image](https://user-images.githubusercontent.com/47651623/219850996-c243b9fc-b067-4a58-bf28-575fce980658.png)
  * **設定環境變數，對 "環境變數 -> 系統變數" 點選新增** <br/>
![image](https://user-images.githubusercontent.com/47651623/217977281-b92de9cb-73bf-4abf-a408-6bdf7786c2e4.png)
  * **變數名稱設定: ZOOKEEPER_HOME，變數值為 Zookeeper 的安裝路徑** <br/>
![image](https://user-images.githubusercontent.com/47651623/219851083-275c25bb-19a5-498b-a7d2-2bfa7a4aabe5.png)
  * **設定完成後，選擇系統變數 "Path" 進行編輯** <br/>
![image](https://user-images.githubusercontent.com/47651623/217977787-e3bb0946-99e0-428c-8022-5e24c9b1f07f.png)
  * **點選新增，並打上: %ZOOKEEPER_HOME%\bin，按下確定完成編輯** <br/>
![image](https://user-images.githubusercontent.com/47651623/218673312-236af1f6-2259-439e-9738-933b19d65599.png)
  * **於 Cmd 輸入: zkServer 啟動 Zookeeper** <br/>
![image](https://user-images.githubusercontent.com/47651623/218949100-3024409b-85d2-498a-9e41-5895a436b1b4.png)
  * **若出現以下畫面代表 Port 號相撞，請在 zoo.cfg 新增一行參數: admin.serverPort=8079 (Port 號自訂)** <br/>
![image](https://user-images.githubusercontent.com/47651623/218951209-fa05b91b-3679-4515-b011-35cebbb4c3f4.png)

<br/>

* **安裝 Kafka**
  * **下載地址: https://kafka.apache.org/downloads**
  * **請下載 Binary 版本，Source 版本的執行會有錯誤**
  * **下載完畢後解壓縮到自訂目錄，目錄的資料夾路徑不可以有空格，否則執行一樣會有錯誤**
![image](https://user-images.githubusercontent.com/47651623/218952653-9abbd91d-47d9-4097-9a16-743dea6bb43b.png)
  * **修改設定 server.properties，路徑: D:\kafka_2.12-3.2.3\config\server.properties**
  * **log.dirs=/tmp/kafka-logs –> log.dirs=D:/kafka_2.12-3.2.3/logs (一樣注意斜線方向"/")**
![image](https://user-images.githubusercontent.com/47651623/218958065-eeb8a5d8-8bd8-41a9-9ad4-ed99b742260c.png)
  * **啟動 Kafka**
  * **打開 Cmd 切換到 bin 目錄底下，輸入指令: .\windows\kafka-server-start.bat ..\config\server.properties**
![image](https://user-images.githubusercontent.com/47651623/218959281-511389a2-4646-42d6-b7e1-313785c3e7f5.png)
  * **測試 Kafka，新開一個 Cmd 視窗，切換路徑至 D:\kafka_2.12-3.2.3\bin\windows**
  * **輸入指令: kafka-topics.bat --create --bootstrap-server localhost:9092 --topic test --replication-factor 1 --partitions 1**
![image](https://user-images.githubusercontent.com/47651623/218962568-7adfa4df-895f-4a00-8435-8b6266d577c2.png)

---

> ### 進行專案測試
* **啟動 Kafka Server**
  * **執行 Zookeeper & Kafka Server**
![image](https://user-images.githubusercontent.com/47651623/220006413-993fa48b-bc6d-4ee9-8473-36a07096c807.png)
* **啟動專案**
  * **先啟動 Producer 專案，後啟動 Consumer 專案，順序不可調換 (原因是 RabbitMq 的 Queue 是由 Producer-Demo 的 rabbitAdmin 建立的)** <br/>
  * **於網址列輸入: http://localhost:8090/rabbitMqProducerController/sendMessage?exchangeName=direct-exchange&routingKey=admin&messageData=Test_RabbitMQ_Project** <br/>
  * **會看到 Consumer_Demo 的 Console 打印: Recieved Message From RabbitMQ: Test_RabbitMQ_Project，代表執行成功** <br/>
![image](https://user-images.githubusercontent.com/47651623/219844899-20c5d494-4305-40c9-8e63-6b20aa60b57c.png)


http://localhost:8090/kafkaProducerController/sendMessage?message=Test_RabbitMQ_Project


## 參考資料 - references
* [RabbitMQ 安装-1](https://cloud.tencent.com/developer/article/1582235 "")
* [RabbitMQ 安装-2](https://mybaseball52.medium.com/install-rabbitmq-on-win-10-a039d48e1c80 "")
* [SpringBoot + RabbitMQ 範例](https://www.javainuse.com/messaging/rabbitmq/exchange "")
* [Kafka 安装-1](https://blog.yowko.com/kafka-on-windows/ "")
* [Kafka 安装-2](https://blog.csdn.net/qq_35461948/article/details/117772904 "")
