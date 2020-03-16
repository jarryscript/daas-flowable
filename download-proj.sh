MODELNAME=$1
DEST_HOST=philip@demo.doublechaintech.com
mkdir -p ~/githome/
cd ~/githome && git clone https://github.com/doublechaintech/${MODELNAME}-biz-suite.git
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui&& cp -Ra ~/githome/pim-biz-suite/bizui/src/common/* src/common/ 
cd ~/githome/${MODELNAME}-biz-suite/bizui && yarn build && cd ../../
ssh ${DEST_HOST} "mkdir ~/resin-3.1.12/webapps/${MODELNAME}"
ssh ${DEST_HOST} "mkdir ~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}"
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* ${DEST_HOST}:~/resin-3.1.12/webapps/${MODELNAME}/
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* ${DEST_HOST}:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/
ssh ${DEST_HOST} "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/${MODELNAME}/WEB-INF/${MODELNAME}_core_src/META-INF/${MODELNAME}_mysql.sql"

