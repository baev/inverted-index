## Алгоритм для построения обратного индекса

Для работы необходимо:

* **JDK 1.7 or above**
* **Maven 3.0.5**
* **PhantomJS 1.9**

### PhantomJS

Скрипт для загрузки и установки PhantomJS (**apt-get скачивает старую версию**)

```bash
echo "installing phantomjs..."
PHANTOMJS_PACKAGE=phantomjs-1.9.2-linux-x86_64
cd /usr/local/share
sudo wget http://phantomjs.googlecode.com/files/$PHANTOMJS_PACKAGE.tar.bz2
sudo tar xjf $PHANTOMJS_PACKAGE.tar.bz2
sudo ln -s /usr/local/share/$PHANTOMJS_PACKAGE/bin/phantomjs /usr/local/share/phantomjs
sudo ln -s /usr/local/share/$PHANTOMJS_PACKAGE/bin/phantomjs /usr/local/bin/phantomjs
sudo ln -s /usr/local/share/$PHANTOMJS_PACKAGE/bin/phantomjs /usr/bin/phantomjs
```

Либо можно воспользоваться brew (mac OS)

    brew install phantomjs
  

### Запуск

    git clone git@github.com:baev/inverted-index.git
    cd inverted-index
    mvn clean install
    mvn exec:java
    
Программа откроет http://az.lib.ru/t/tolstoj_lew_nikolaewich/text_0080.shtml, для каждого параграфа сделает документы, 
после чего построит обратный индекс по документам. 

