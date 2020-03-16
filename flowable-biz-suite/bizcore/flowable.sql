drop database flowable;
create database flowable;
use flowable;
-- MySQL dump 10.13  Distrib 5.7.27, for macos10.14 (x86_64)
--
-- Host: localhost    Database: flowable
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACT_APP_APPDEF`
--

DROP TABLE IF EXISTS `ACT_APP_APPDEF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_APP_APPDEF` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_IDX_APP_DEF_UNIQ` (`KEY_`,`VERSION_`,`TENANT_ID_`),
  KEY `ACT_IDX_APP_DEF_DPLY` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_APP_DEF_DPLY` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_APP_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_APP_APPDEF`
--

LOCK TABLES `ACT_APP_APPDEF` WRITE;
/*!40000 ALTER TABLE `ACT_APP_APPDEF` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_APP_APPDEF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_APP_DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `ACT_APP_DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_APP_DATABASECHANGELOG` (
  `ID` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_APP_DATABASECHANGELOG`
--

LOCK TABLES `ACT_APP_DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `ACT_APP_DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `ACT_APP_DATABASECHANGELOG` VALUES ('1','flowable','org/flowable/app/db/liquibase/flowable-app-db-changelog.xml','2020-02-25 11:31:15',1,'EXECUTED','8:496fc778bdf2ab13f2e1926d0e63e0a2','createTable tableName=ACT_APP_DEPLOYMENT; createTable tableName=ACT_APP_DEPLOYMENT_RESOURCE; addForeignKeyConstraint baseTableName=ACT_APP_DEPLOYMENT_RESOURCE, constraintName=ACT_FK_APP_RSRC_DPL, referencedTableName=ACT_APP_DEPLOYMENT; createIndex...','',NULL,'3.6.3',NULL,NULL,'2601475697'),('2','flowable','org/flowable/app/db/liquibase/flowable-app-db-changelog.xml','2020-02-25 11:31:15',2,'EXECUTED','8:ccea9ebfb6c1f8367ca4dd473fcbb7db','modifyDataType columnName=DEPLOY_TIME_, tableName=ACT_APP_DEPLOYMENT','',NULL,'3.6.3',NULL,NULL,'2601475697'),('3','flowable','org/flowable/app/db/liquibase/flowable-app-db-changelog.xml','2020-02-25 11:31:15',3,'EXECUTED','8:f1f8aff320aade831944ebad24355f3d','createIndex indexName=ACT_IDX_APP_DEF_UNIQ, tableName=ACT_APP_APPDEF','',NULL,'3.6.3',NULL,NULL,'2601475697');
/*!40000 ALTER TABLE `ACT_APP_DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_APP_DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `ACT_APP_DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_APP_DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_APP_DATABASECHANGELOGLOCK`
--

LOCK TABLES `ACT_APP_DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `ACT_APP_DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `ACT_APP_DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `ACT_APP_DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_APP_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_APP_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_APP_DEPLOYMENT` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOY_TIME_` datetime(3) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_APP_DEPLOYMENT`
--

LOCK TABLES `ACT_APP_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_APP_DEPLOYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_APP_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_APP_DEPLOYMENT_RESOURCE`
--

DROP TABLE IF EXISTS `ACT_APP_DEPLOYMENT_RESOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_APP_DEPLOYMENT_RESOURCE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_BYTES_` longblob,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_APP_RSRC_DPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_APP_RSRC_DPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_APP_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_APP_DEPLOYMENT_RESOURCE`
--

LOCK TABLES `ACT_APP_DEPLOYMENT_RESOURCE` WRITE;
/*!40000 ALTER TABLE `ACT_APP_DEPLOYMENT_RESOURCE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_APP_DEPLOYMENT_RESOURCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_CASEDEF`
--

DROP TABLE IF EXISTS `ACT_CMMN_CASEDEF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_CASEDEF` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` bit(1) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_IDX_CASE_DEF_UNIQ` (`KEY_`,`VERSION_`,`TENANT_ID_`),
  KEY `ACT_IDX_CASE_DEF_DPLY` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_CASE_DEF_DPLY` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_CMMN_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_CASEDEF`
--

LOCK TABLES `ACT_CMMN_CASEDEF` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_CASEDEF` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_CASEDEF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `ACT_CMMN_DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_DATABASECHANGELOG` (
  `ID` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_DATABASECHANGELOG`
--

LOCK TABLES `ACT_CMMN_DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `ACT_CMMN_DATABASECHANGELOG` VALUES ('1','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:14',1,'EXECUTED','8:8b4b922d90b05ff27483abefc9597aa6','createTable tableName=ACT_CMMN_DEPLOYMENT; createTable tableName=ACT_CMMN_DEPLOYMENT_RESOURCE; addForeignKeyConstraint baseTableName=ACT_CMMN_DEPLOYMENT_RESOURCE, constraintName=ACT_FK_CMMN_RSRC_DPL, referencedTableName=ACT_CMMN_DEPLOYMENT; create...','',NULL,'3.6.3',NULL,NULL,'2601474239'),('2','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:14',2,'EXECUTED','8:65e39b3d385706bb261cbeffe7533cbe','addColumn tableName=ACT_CMMN_CASEDEF; addColumn tableName=ACT_CMMN_DEPLOYMENT_RESOURCE; addColumn tableName=ACT_CMMN_RU_CASE_INST; addColumn tableName=ACT_CMMN_RU_PLAN_ITEM_INST','',NULL,'3.6.3',NULL,NULL,'2601474239'),('3','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:14',3,'EXECUTED','8:c01f6e802b49436b4489040da3012359','addColumn tableName=ACT_CMMN_RU_PLAN_ITEM_INST; addColumn tableName=ACT_CMMN_RU_CASE_INST; createIndex indexName=ACT_IDX_PLAN_ITEM_STAGE_INST, tableName=ACT_CMMN_RU_PLAN_ITEM_INST; addColumn tableName=ACT_CMMN_RU_PLAN_ITEM_INST; addColumn tableNam...','',NULL,'3.6.3',NULL,NULL,'2601474239'),('4','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:15',4,'EXECUTED','8:e40d29cb79345b7fb5afd38a7f0ba8fc','createTable tableName=ACT_CMMN_HI_PLAN_ITEM_INST; addColumn tableName=ACT_CMMN_RU_MIL_INST; addColumn tableName=ACT_CMMN_HI_MIL_INST','',NULL,'3.6.3',NULL,NULL,'2601474239'),('5','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:15',5,'EXECUTED','8:70349de472f87368dcdec971a10311a0','modifyDataType columnName=DEPLOY_TIME_, tableName=ACT_CMMN_DEPLOYMENT; modifyDataType columnName=START_TIME_, tableName=ACT_CMMN_RU_CASE_INST; modifyDataType columnName=START_TIME_, tableName=ACT_CMMN_RU_PLAN_ITEM_INST; modifyDataType columnName=T...','',NULL,'3.6.3',NULL,NULL,'2601474239'),('6','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:15',6,'EXECUTED','8:10e82e26a7fee94c32a92099c059c18c','createIndex indexName=ACT_IDX_CASE_DEF_UNIQ, tableName=ACT_CMMN_CASEDEF','',NULL,'3.6.3',NULL,NULL,'2601474239'),('7','flowable','org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml','2020-02-25 11:31:15',7,'EXECUTED','8:530bc81a1e30618ccf4a2da1f7c6c043','renameColumn newColumnName=CREATE_TIME_, oldColumnName=START_TIME_, tableName=ACT_CMMN_RU_PLAN_ITEM_INST; renameColumn newColumnName=CREATE_TIME_, oldColumnName=CREATED_TIME_, tableName=ACT_CMMN_HI_PLAN_ITEM_INST; addColumn tableName=ACT_CMMN_RU_P...','',NULL,'3.6.3',NULL,NULL,'2601474239');
/*!40000 ALTER TABLE `ACT_CMMN_DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `ACT_CMMN_DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_DATABASECHANGELOGLOCK`
--

LOCK TABLES `ACT_CMMN_DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `ACT_CMMN_DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `ACT_CMMN_DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_CMMN_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_DEPLOYMENT` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOY_TIME_` datetime(3) DEFAULT NULL,
  `PARENT_DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_DEPLOYMENT`
--

LOCK TABLES `ACT_CMMN_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_DEPLOYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_DEPLOYMENT_RESOURCE`
--

DROP TABLE IF EXISTS `ACT_CMMN_DEPLOYMENT_RESOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_DEPLOYMENT_RESOURCE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_BYTES_` longblob,
  `GENERATED_` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_CMMN_RSRC_DPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_CMMN_RSRC_DPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_CMMN_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_DEPLOYMENT_RESOURCE`
--

LOCK TABLES `ACT_CMMN_DEPLOYMENT_RESOURCE` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_DEPLOYMENT_RESOURCE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_DEPLOYMENT_RESOURCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_HI_CASE_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_HI_CASE_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_HI_CASE_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_HI_CASE_INST`
--

LOCK TABLES `ACT_CMMN_HI_CASE_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_HI_CASE_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_HI_CASE_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_HI_MIL_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_HI_MIL_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_HI_MIL_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TIME_STAMP_` datetime(3) DEFAULT NULL,
  `CASE_INST_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_HI_MIL_INST`
--

LOCK TABLES `ACT_CMMN_HI_MIL_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_HI_MIL_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_HI_MIL_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_HI_PLAN_ITEM_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_HI_PLAN_ITEM_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_HI_PLAN_ITEM_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STAGE_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `IS_STAGE_` bit(1) DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ITEM_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ITEM_DEFINITION_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_AVAILABLE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_ENABLED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_DISABLED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_STARTED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_SUSPENDED_TIME_` datetime(3) DEFAULT NULL,
  `COMPLETED_TIME_` datetime(3) DEFAULT NULL,
  `OCCURRED_TIME_` datetime(3) DEFAULT NULL,
  `TERMINATED_TIME_` datetime(3) DEFAULT NULL,
  `EXIT_TIME_` datetime(3) DEFAULT NULL,
  `ENDED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REFERENCE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REFERENCE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `ENTRY_CRITERION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXIT_CRITERION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_HI_PLAN_ITEM_INST`
--

LOCK TABLES `ACT_CMMN_HI_PLAN_ITEM_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_HI_PLAN_ITEM_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_HI_PLAN_ITEM_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_RU_CASE_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_RU_CASE_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_RU_CASE_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `LOCK_TIME_` datetime(3) DEFAULT NULL,
  `IS_COMPLETEABLE_` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_CASE_INST_CASE_DEF` (`CASE_DEF_ID_`),
  KEY `ACT_IDX_CASE_INST_PARENT` (`PARENT_ID_`),
  CONSTRAINT `ACT_FK_CASE_INST_CASE_DEF` FOREIGN KEY (`CASE_DEF_ID_`) REFERENCES `ACT_CMMN_CASEDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_RU_CASE_INST`
--

LOCK TABLES `ACT_CMMN_RU_CASE_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_RU_CASE_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_RU_CASE_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_RU_MIL_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_RU_MIL_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_RU_MIL_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TIME_STAMP_` datetime(3) DEFAULT NULL,
  `CASE_INST_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_MIL_CASE_DEF` (`CASE_DEF_ID_`),
  KEY `ACT_IDX_MIL_CASE_INST` (`CASE_INST_ID_`),
  CONSTRAINT `ACT_FK_MIL_CASE_DEF` FOREIGN KEY (`CASE_DEF_ID_`) REFERENCES `ACT_CMMN_CASEDEF` (`ID_`),
  CONSTRAINT `ACT_FK_MIL_CASE_INST` FOREIGN KEY (`CASE_INST_ID_`) REFERENCES `ACT_CMMN_RU_CASE_INST` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_RU_MIL_INST`
--

LOCK TABLES `ACT_CMMN_RU_MIL_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_RU_MIL_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_RU_MIL_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_RU_PLAN_ITEM_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_RU_PLAN_ITEM_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_RU_PLAN_ITEM_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STAGE_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `IS_STAGE_` bit(1) DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `STATE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REFERENCE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REFERENCE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `ITEM_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ITEM_DEFINITION_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `IS_COMPLETEABLE_` bit(1) DEFAULT NULL,
  `IS_COUNT_ENABLED_` bit(1) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `SENTRY_PART_INST_COUNT_` int(11) DEFAULT NULL,
  `LAST_AVAILABLE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_ENABLED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_DISABLED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_STARTED_TIME_` datetime(3) DEFAULT NULL,
  `LAST_SUSPENDED_TIME_` datetime(3) DEFAULT NULL,
  `COMPLETED_TIME_` datetime(3) DEFAULT NULL,
  `OCCURRED_TIME_` datetime(3) DEFAULT NULL,
  `TERMINATED_TIME_` datetime(3) DEFAULT NULL,
  `EXIT_TIME_` datetime(3) DEFAULT NULL,
  `ENDED_TIME_` datetime(3) DEFAULT NULL,
  `ENTRY_CRITERION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXIT_CRITERION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_PLAN_ITEM_CASE_DEF` (`CASE_DEF_ID_`),
  KEY `ACT_IDX_PLAN_ITEM_CASE_INST` (`CASE_INST_ID_`),
  KEY `ACT_IDX_PLAN_ITEM_STAGE_INST` (`STAGE_INST_ID_`),
  CONSTRAINT `ACT_FK_PLAN_ITEM_CASE_DEF` FOREIGN KEY (`CASE_DEF_ID_`) REFERENCES `ACT_CMMN_CASEDEF` (`ID_`),
  CONSTRAINT `ACT_FK_PLAN_ITEM_CASE_INST` FOREIGN KEY (`CASE_INST_ID_`) REFERENCES `ACT_CMMN_RU_CASE_INST` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_RU_PLAN_ITEM_INST`
--

LOCK TABLES `ACT_CMMN_RU_PLAN_ITEM_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_RU_PLAN_ITEM_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_RU_PLAN_ITEM_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CMMN_RU_SENTRY_PART_INST`
--

DROP TABLE IF EXISTS `ACT_CMMN_RU_SENTRY_PART_INST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CMMN_RU_SENTRY_PART_INST` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) NOT NULL,
  `CASE_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CASE_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PLAN_ITEM_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ON_PART_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `IF_PART_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TIME_STAMP_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_SENTRY_CASE_DEF` (`CASE_DEF_ID_`),
  KEY `ACT_IDX_SENTRY_CASE_INST` (`CASE_INST_ID_`),
  KEY `ACT_IDX_SENTRY_PLAN_ITEM` (`PLAN_ITEM_INST_ID_`),
  CONSTRAINT `ACT_FK_SENTRY_CASE_DEF` FOREIGN KEY (`CASE_DEF_ID_`) REFERENCES `ACT_CMMN_CASEDEF` (`ID_`),
  CONSTRAINT `ACT_FK_SENTRY_CASE_INST` FOREIGN KEY (`CASE_INST_ID_`) REFERENCES `ACT_CMMN_RU_CASE_INST` (`ID_`),
  CONSTRAINT `ACT_FK_SENTRY_PLAN_ITEM` FOREIGN KEY (`PLAN_ITEM_INST_ID_`) REFERENCES `ACT_CMMN_RU_PLAN_ITEM_INST` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CMMN_RU_SENTRY_PART_INST`
--

LOCK TABLES `ACT_CMMN_RU_SENTRY_PART_INST` WRITE;
/*!40000 ALTER TABLE `ACT_CMMN_RU_SENTRY_PART_INST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CMMN_RU_SENTRY_PART_INST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CO_CONTENT_ITEM`
--

DROP TABLE IF EXISTS `ACT_CO_CONTENT_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CO_CONTENT_ITEM` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `MIME_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTENT_STORE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTENT_STORE_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `FIELD_` varchar(400) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTENT_AVAILABLE_` bit(1) DEFAULT b'0',
  `CREATED_` timestamp(6) NULL DEFAULT NULL,
  `CREATED_BY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LAST_MODIFIED_` timestamp(6) NULL DEFAULT NULL,
  `LAST_MODIFIED_BY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTENT_SIZE_` bigint(20) DEFAULT '0',
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `idx_contitem_taskid` (`TASK_ID_`),
  KEY `idx_contitem_procid` (`PROC_INST_ID_`),
  KEY `idx_contitem_scope` (`SCOPE_ID_`,`SCOPE_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CO_CONTENT_ITEM`
--

LOCK TABLES `ACT_CO_CONTENT_ITEM` WRITE;
/*!40000 ALTER TABLE `ACT_CO_CONTENT_ITEM` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_CO_CONTENT_ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CO_DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `ACT_CO_DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CO_DATABASECHANGELOG` (
  `ID` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CO_DATABASECHANGELOG`
--

LOCK TABLES `ACT_CO_DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `ACT_CO_DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `ACT_CO_DATABASECHANGELOG` VALUES ('1','activiti','org/flowable/content/db/liquibase/flowable-content-db-changelog.xml','2020-02-25 11:31:14',1,'EXECUTED','8:7644d7165cfe799200a2abdd3419e8b6','createTable tableName=ACT_CO_CONTENT_ITEM; createIndex indexName=idx_contitem_taskid, tableName=ACT_CO_CONTENT_ITEM; createIndex indexName=idx_contitem_procid, tableName=ACT_CO_CONTENT_ITEM','',NULL,'3.6.3',NULL,NULL,'2601473981'),('2','flowable','org/flowable/content/db/liquibase/flowable-content-db-changelog.xml','2020-02-25 11:31:14',2,'EXECUTED','8:fe7b11ac7dbbf9c43006b23bbab60bab','addColumn tableName=ACT_CO_CONTENT_ITEM; createIndex indexName=idx_contitem_scope, tableName=ACT_CO_CONTENT_ITEM','',NULL,'3.6.3',NULL,NULL,'2601473981');
/*!40000 ALTER TABLE `ACT_CO_DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_CO_DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `ACT_CO_DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_CO_DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_CO_DATABASECHANGELOGLOCK`
--

LOCK TABLES `ACT_CO_DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `ACT_CO_DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `ACT_CO_DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `ACT_CO_DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `ACT_DMN_DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_DATABASECHANGELOG` (
  `ID` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_DATABASECHANGELOG`
--

LOCK TABLES `ACT_DMN_DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `ACT_DMN_DATABASECHANGELOG` VALUES ('1','activiti','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',1,'EXECUTED','8:c8701f1c71018b55029f450b2e9a10a1','createTable tableName=ACT_DMN_DEPLOYMENT; createTable tableName=ACT_DMN_DEPLOYMENT_RESOURCE; createTable tableName=ACT_DMN_DECISION_TABLE','',NULL,'3.6.3',NULL,NULL,'2601473374'),('2','flowable','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',2,'EXECUTED','8:47f94b27feb7df8a30d4e338c7bd5fb8','createTable tableName=ACT_DMN_HI_DECISION_EXECUTION','',NULL,'3.6.3',NULL,NULL,'2601473374'),('3','flowable','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',3,'EXECUTED','8:ac17eae89fbdccb6e08daf3c7797b579','addColumn tableName=ACT_DMN_HI_DECISION_EXECUTION','',NULL,'3.6.3',NULL,NULL,'2601473374'),('4','flowable','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',4,'EXECUTED','8:f73aabc4529e7292c2942073d1cff6f9','dropColumn columnName=PARENT_DEPLOYMENT_ID_, tableName=ACT_DMN_DECISION_TABLE','',NULL,'3.6.3',NULL,NULL,'2601473374'),('5','flowable','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',5,'EXECUTED','8:3e03528582dd4eeb4eb41f9b9539140d','modifyDataType columnName=DEPLOY_TIME_, tableName=ACT_DMN_DEPLOYMENT; modifyDataType columnName=START_TIME_, tableName=ACT_DMN_HI_DECISION_EXECUTION; modifyDataType columnName=END_TIME_, tableName=ACT_DMN_HI_DECISION_EXECUTION','',NULL,'3.6.3',NULL,NULL,'2601473374'),('6','flowable','org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml','2020-02-25 11:31:13',6,'EXECUTED','8:646c6a061e0b6e8a62e69844ff96abb0','createIndex indexName=ACT_IDX_DEC_TBL_UNIQ, tableName=ACT_DMN_DECISION_TABLE','',NULL,'3.6.3',NULL,NULL,'2601473374');
/*!40000 ALTER TABLE `ACT_DMN_DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `ACT_DMN_DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_DATABASECHANGELOGLOCK`
--

LOCK TABLES `ACT_DMN_DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `ACT_DMN_DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `ACT_DMN_DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_DECISION_TABLE`
--

DROP TABLE IF EXISTS `ACT_DMN_DECISION_TABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_DECISION_TABLE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_IDX_DEC_TBL_UNIQ` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_DECISION_TABLE`
--

LOCK TABLES `ACT_DMN_DECISION_TABLE` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_DECISION_TABLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_DMN_DECISION_TABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_DMN_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_DEPLOYMENT` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOY_TIME_` datetime(3) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_DEPLOYMENT`
--

LOCK TABLES `ACT_DMN_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_DEPLOYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_DMN_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_DEPLOYMENT_RESOURCE`
--

DROP TABLE IF EXISTS `ACT_DMN_DEPLOYMENT_RESOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_DEPLOYMENT_RESOURCE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_BYTES_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_DEPLOYMENT_RESOURCE`
--

LOCK TABLES `ACT_DMN_DEPLOYMENT_RESOURCE` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_DEPLOYMENT_RESOURCE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_DMN_DEPLOYMENT_RESOURCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_DMN_HI_DECISION_EXECUTION`
--

DROP TABLE IF EXISTS `ACT_DMN_HI_DECISION_EXECUTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_DMN_HI_DECISION_EXECUTION` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DECISION_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `INSTANCE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `FAILED_` bit(1) DEFAULT b'0',
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_JSON_` longtext COLLATE utf8mb4_bin,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_DMN_HI_DECISION_EXECUTION`
--

LOCK TABLES `ACT_DMN_HI_DECISION_EXECUTION` WRITE;
/*!40000 ALTER TABLE `ACT_DMN_HI_DECISION_EXECUTION` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_DMN_HI_DECISION_EXECUTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_EVT_LOG`
--

DROP TABLE IF EXISTS `ACT_EVT_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_EVT_LOG` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_EVT_LOG`
--

LOCK TABLES `ACT_EVT_LOG` WRITE;
/*!40000 ALTER TABLE `ACT_EVT_LOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_EVT_LOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `ACT_FO_DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_DATABASECHANGELOG` (
  `ID` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_DATABASECHANGELOG`
--

LOCK TABLES `ACT_FO_DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `ACT_FO_DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `ACT_FO_DATABASECHANGELOG` VALUES ('1','activiti','org/flowable/form/db/liquibase/flowable-form-db-changelog.xml','2020-02-25 11:31:13',1,'EXECUTED','8:033ebf9380889aed7c453927ecc3250d','createTable tableName=ACT_FO_FORM_DEPLOYMENT; createTable tableName=ACT_FO_FORM_RESOURCE; createTable tableName=ACT_FO_FORM_DEFINITION; createTable tableName=ACT_FO_FORM_INSTANCE','',NULL,'3.6.3',NULL,NULL,'2601473707'),('2','flowable','org/flowable/form/db/liquibase/flowable-form-db-changelog.xml','2020-02-25 11:31:13',2,'EXECUTED','8:986365ceb40445ce3b27a8e6b40f159b','addColumn tableName=ACT_FO_FORM_INSTANCE','',NULL,'3.6.3',NULL,NULL,'2601473707'),('3','flowable','org/flowable/form/db/liquibase/flowable-form-db-changelog.xml','2020-02-25 11:31:13',3,'EXECUTED','8:abf482518ceb09830ef674e52c06bf15','dropColumn columnName=PARENT_DEPLOYMENT_ID_, tableName=ACT_FO_FORM_DEFINITION','',NULL,'3.6.3',NULL,NULL,'2601473707'),('4','flowable','org/flowable/form/db/liquibase/flowable-form-db-changelog.xml','2020-02-25 11:31:13',4,'EXECUTED','8:2087829f22a4b2298dbf530681c74854','modifyDataType columnName=DEPLOY_TIME_, tableName=ACT_FO_FORM_DEPLOYMENT; modifyDataType columnName=SUBMITTED_DATE_, tableName=ACT_FO_FORM_INSTANCE','',NULL,'3.6.3',NULL,NULL,'2601473707'),('5','flowable','org/flowable/form/db/liquibase/flowable-form-db-changelog.xml','2020-02-25 11:31:13',5,'EXECUTED','8:b4be732b89e5ca028bdd520c6ad4d446','createIndex indexName=ACT_IDX_FORM_DEF_UNIQ, tableName=ACT_FO_FORM_DEFINITION','',NULL,'3.6.3',NULL,NULL,'2601473707');
/*!40000 ALTER TABLE `ACT_FO_DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `ACT_FO_DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_DATABASECHANGELOGLOCK`
--

LOCK TABLES `ACT_FO_DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `ACT_FO_DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `ACT_FO_DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `ACT_FO_DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_FORM_DEFINITION`
--

DROP TABLE IF EXISTS `ACT_FO_FORM_DEFINITION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_FORM_DEFINITION` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_IDX_FORM_DEF_UNIQ` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_FORM_DEFINITION`
--

LOCK TABLES `ACT_FO_FORM_DEFINITION` WRITE;
/*!40000 ALTER TABLE `ACT_FO_FORM_DEFINITION` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_FO_FORM_DEFINITION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_FORM_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_FO_FORM_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_FORM_DEPLOYMENT` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOY_TIME_` datetime(3) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_FORM_DEPLOYMENT`
--

LOCK TABLES `ACT_FO_FORM_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_FO_FORM_DEPLOYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_FO_FORM_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_FORM_INSTANCE`
--

DROP TABLE IF EXISTS `ACT_FO_FORM_INSTANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_FORM_INSTANCE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `FORM_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TASK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUBMITTED_DATE_` datetime(3) DEFAULT NULL,
  `SUBMITTED_BY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `FORM_VALUES_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_FORM_INSTANCE`
--

LOCK TABLES `ACT_FO_FORM_INSTANCE` WRITE;
/*!40000 ALTER TABLE `ACT_FO_FORM_INSTANCE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_FO_FORM_INSTANCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_FO_FORM_RESOURCE`
--

DROP TABLE IF EXISTS `ACT_FO_FORM_RESOURCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_FO_FORM_RESOURCE` (
  `ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_BYTES_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_FO_FORM_RESOURCE`
--

LOCK TABLES `ACT_FO_FORM_RESOURCE` WRITE;
/*!40000 ALTER TABLE `ACT_FO_FORM_RESOURCE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_FO_FORM_RESOURCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_GE_BYTEARRAY`
--

DROP TABLE IF EXISTS `ACT_GE_BYTEARRAY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_GE_BYTEARRAY` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_RE_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_GE_BYTEARRAY`
--

LOCK TABLES `ACT_GE_BYTEARRAY` WRITE;
/*!40000 ALTER TABLE `ACT_GE_BYTEARRAY` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_GE_BYTEARRAY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_GE_PROPERTY`
--

DROP TABLE IF EXISTS `ACT_GE_PROPERTY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_GE_PROPERTY` (
  `NAME_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_GE_PROPERTY`
--

LOCK TABLES `ACT_GE_PROPERTY` WRITE;
/*!40000 ALTER TABLE `ACT_GE_PROPERTY` DISABLE KEYS */;
INSERT INTO `ACT_GE_PROPERTY` VALUES ('cfg.execution-related-entities-count','true',1),('cfg.task-related-entities-count','true',1),('common.schema.version','6.5.0.1',1),('entitylink.schema.version','6.5.0.1',1),('eventsubscription.schema.version','6.5.0.1',1),('identitylink.schema.version','6.5.0.1',1),('job.schema.version','6.5.0.1',1),('next.dbid','1',1),('schema.history','create(6.5.0.1)',1),('schema.version','6.5.0.1',1),('task.schema.version','6.5.0.1',1),('variable.schema.version','6.5.0.1',1);
/*!40000 ALTER TABLE `ACT_GE_PROPERTY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_ACTINST`
--

DROP TABLE IF EXISTS `ACT_HI_ACTINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_ACTINST` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT '1',
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_ACTINST`
--

LOCK TABLES `ACT_HI_ACTINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_ACTINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_ACTINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_ATTACHMENT`
--

DROP TABLE IF EXISTS `ACT_HI_ATTACHMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_ATTACHMENT` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_ATTACHMENT`
--

LOCK TABLES `ACT_HI_ATTACHMENT` WRITE;
/*!40000 ALTER TABLE `ACT_HI_ATTACHMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_ATTACHMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_COMMENT`
--

DROP TABLE IF EXISTS `ACT_HI_COMMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_COMMENT` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_COMMENT`
--

LOCK TABLES `ACT_HI_COMMENT` WRITE;
/*!40000 ALTER TABLE `ACT_HI_COMMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_COMMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_DETAIL`
--

DROP TABLE IF EXISTS `ACT_HI_DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_DETAIL` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_DETAIL`
--

LOCK TABLES `ACT_HI_DETAIL` WRITE;
/*!40000 ALTER TABLE `ACT_HI_DETAIL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_DETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_ENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_HI_ENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_ENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `LINK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HIERARCHY_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ENT_LNK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`,`LINK_TYPE_`),
  KEY `ACT_IDX_HI_ENT_LNK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`,`LINK_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_ENTITYLINK`
--

LOCK TABLES `ACT_HI_ENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_HI_ENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_ENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_IDENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_HI_IDENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_IDENT_LNK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_IDENTITYLINK`
--

LOCK TABLES `ACT_HI_IDENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_HI_IDENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_IDENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_PROCINST`
--

DROP TABLE IF EXISTS `ACT_HI_PROCINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_PROCINST` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT '1',
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_PROCINST`
--

LOCK TABLES `ACT_HI_PROCINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_PROCINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_PROCINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_TASKINST`
--

DROP TABLE IF EXISTS `ACT_HI_TASKINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_TASKINST` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT '1',
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_TASKINST`
--

LOCK TABLES `ACT_HI_TASKINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_TASKINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_TASKINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_TSK_LOG`
--

DROP TABLE IF EXISTS `ACT_HI_TSK_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_TSK_LOG` (
  `ID_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DATA_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_TSK_LOG`
--

LOCK TABLES `ACT_HI_TSK_LOG` WRITE;
/*!40000 ALTER TABLE `ACT_HI_TSK_LOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_TSK_LOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_HI_VARINST`
--

DROP TABLE IF EXISTS `ACT_HI_VARINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_HI_VARINST` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT '1',
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_VAR_SCOPE_ID_TYPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_VAR_SUB_ID_TYPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_EXE` (`EXECUTION_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_HI_VARINST`
--

LOCK TABLES `ACT_HI_VARINST` WRITE;
/*!40000 ALTER TABLE `ACT_HI_VARINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_HI_VARINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_BYTEARRAY`
--

DROP TABLE IF EXISTS `ACT_ID_BYTEARRAY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_BYTEARRAY` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `BYTES_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_BYTEARRAY`
--

LOCK TABLES `ACT_ID_BYTEARRAY` WRITE;
/*!40000 ALTER TABLE `ACT_ID_BYTEARRAY` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_BYTEARRAY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_GROUP`
--

DROP TABLE IF EXISTS `ACT_ID_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_GROUP` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_GROUP`
--

LOCK TABLES `ACT_ID_GROUP` WRITE;
/*!40000 ALTER TABLE `ACT_ID_GROUP` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_GROUP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_INFO`
--

DROP TABLE IF EXISTS `ACT_ID_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_INFO` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_INFO`
--

LOCK TABLES `ACT_ID_INFO` WRITE;
/*!40000 ALTER TABLE `ACT_ID_INFO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_MEMBERSHIP`
--

DROP TABLE IF EXISTS `ACT_ID_MEMBERSHIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_MEMBERSHIP` (
  `USER_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `GROUP_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `ACT_ID_GROUP` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `ACT_ID_USER` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_MEMBERSHIP`
--

LOCK TABLES `ACT_ID_MEMBERSHIP` WRITE;
/*!40000 ALTER TABLE `ACT_ID_MEMBERSHIP` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_MEMBERSHIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_PRIV`
--

DROP TABLE IF EXISTS `ACT_ID_PRIV`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_PRIV` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PRIV_NAME` (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_PRIV`
--

LOCK TABLES `ACT_ID_PRIV` WRITE;
/*!40000 ALTER TABLE `ACT_ID_PRIV` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_PRIV` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_PRIV_MAPPING`
--

DROP TABLE IF EXISTS `ACT_ID_PRIV_MAPPING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_PRIV_MAPPING` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `PRIV_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_PRIV_MAPPING` (`PRIV_ID_`),
  KEY `ACT_IDX_PRIV_USER` (`USER_ID_`),
  KEY `ACT_IDX_PRIV_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_PRIV_MAPPING` FOREIGN KEY (`PRIV_ID_`) REFERENCES `ACT_ID_PRIV` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_PRIV_MAPPING`
--

LOCK TABLES `ACT_ID_PRIV_MAPPING` WRITE;
/*!40000 ALTER TABLE `ACT_ID_PRIV_MAPPING` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_PRIV_MAPPING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_PROPERTY`
--

DROP TABLE IF EXISTS `ACT_ID_PROPERTY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_PROPERTY` (
  `NAME_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_PROPERTY`
--

LOCK TABLES `ACT_ID_PROPERTY` WRITE;
/*!40000 ALTER TABLE `ACT_ID_PROPERTY` DISABLE KEYS */;
INSERT INTO `ACT_ID_PROPERTY` VALUES ('schema.version','6.5.0.1',1);
/*!40000 ALTER TABLE `ACT_ID_PROPERTY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_TOKEN`
--

DROP TABLE IF EXISTS `ACT_ID_TOKEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_TOKEN` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TOKEN_VALUE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TOKEN_DATE_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `IP_ADDRESS_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `USER_AGENT_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TOKEN_DATA_` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_TOKEN`
--

LOCK TABLES `ACT_ID_TOKEN` WRITE;
/*!40000 ALTER TABLE `ACT_ID_TOKEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_TOKEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_ID_USER`
--

DROP TABLE IF EXISTS `ACT_ID_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_ID_USER` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DISPLAY_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_ID_USER`
--

LOCK TABLES `ACT_ID_USER` WRITE;
/*!40000 ALTER TABLE `ACT_ID_USER` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_ID_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_PROCDEF_INFO`
--

DROP TABLE IF EXISTS `ACT_PROCDEF_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_PROCDEF_INFO` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_PROCDEF_INFO`
--

LOCK TABLES `ACT_PROCDEF_INFO` WRITE;
/*!40000 ALTER TABLE `ACT_PROCDEF_INFO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_PROCDEF_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_DEPLOYMENT`
--

DROP TABLE IF EXISTS `ACT_RE_DEPLOYMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_DEPLOYMENT` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DERIVED_FROM_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DERIVED_FROM_ROOT_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_DEPLOYMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_DEPLOYMENT`
--

LOCK TABLES `ACT_RE_DEPLOYMENT` WRITE;
/*!40000 ALTER TABLE `ACT_RE_DEPLOYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RE_DEPLOYMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_MODEL`
--

DROP TABLE IF EXISTS `ACT_RE_MODEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_MODEL` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_RE_DEPLOYMENT` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_MODEL`
--

LOCK TABLES `ACT_RE_MODEL` WRITE;
/*!40000 ALTER TABLE `ACT_RE_MODEL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RE_MODEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RE_PROCDEF`
--

DROP TABLE IF EXISTS `ACT_RE_PROCDEF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RE_PROCDEF` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DERIVED_FROM_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DERIVED_FROM_ROOT_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DERIVED_VERSION_` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`DERIVED_VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RE_PROCDEF`
--

LOCK TABLES `ACT_RE_PROCDEF` WRITE;
/*!40000 ALTER TABLE `ACT_RE_PROCDEF` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RE_PROCDEF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_ACTINST`
--

DROP TABLE IF EXISTS `ACT_RU_ACTINST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_ACTINST` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT '1',
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_RU_ACTI_START` (`START_TIME_`),
  KEY `ACT_IDX_RU_ACTI_END` (`END_TIME_`),
  KEY `ACT_IDX_RU_ACTI_PROC` (`PROC_INST_ID_`),
  KEY `ACT_IDX_RU_ACTI_PROC_ACT` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_RU_ACTI_EXEC` (`EXECUTION_ID_`),
  KEY `ACT_IDX_RU_ACTI_EXEC_ACT` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_ACTINST`
--

LOCK TABLES `ACT_RU_ACTINST` WRITE;
/*!40000 ALTER TABLE `ACT_RU_ACTINST` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_ACTINST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_DEADLETTER_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_DEADLETTER_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_DEADLETTER_JOB` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CUSTOM_VALUES_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_DEADLETTER_JOB_EXCEPTION_STACK_ID` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_IDX_DEADLETTER_JOB_CUSTOM_VALUES_ID` (`CUSTOM_VALUES_ID_`),
  KEY `ACT_IDX_DJOB_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_DJOB_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_DJOB_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_CUSTOM_VALUES` FOREIGN KEY (`CUSTOM_VALUES_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_DEADLETTER_JOB`
--

LOCK TABLES `ACT_RU_DEADLETTER_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_DEADLETTER_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_DEADLETTER_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_ENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_RU_ENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_ENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LINK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `REF_SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HIERARCHY_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_ENT_LNK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`,`LINK_TYPE_`),
  KEY `ACT_IDX_ENT_LNK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`,`LINK_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_ENTITYLINK`
--

LOCK TABLES `ACT_RU_ENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_RU_ENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_ENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_EVENT_SUBSCR`
--

DROP TABLE IF EXISTS `ACT_RU_EVENT_SUBSCR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_EVENT_SUBSCR` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_EVENT_SUBSCR`
--

LOCK TABLES `ACT_RU_EVENT_SUBSCR` WRITE;
/*!40000 ALTER TABLE `ACT_RU_EVENT_SUBSCR` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_EVENT_SUBSCR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_EXECUTION`
--

DROP TABLE IF EXISTS `ACT_RU_EXECUTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_EXECUTION` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
  `TASK_COUNT_` int(11) DEFAULT NULL,
  `JOB_COUNT_` int(11) DEFAULT NULL,
  `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
  `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`) ON DELETE CASCADE,
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_EXECUTION`
--

LOCK TABLES `ACT_RU_EXECUTION` WRITE;
/*!40000 ALTER TABLE `ACT_RU_EXECUTION` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_EXECUTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_HISTORY_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_HISTORY_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_HISTORY_JOB` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CUSTOM_VALUES_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ADV_HANDLER_CFG_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_HISTORY_JOB`
--

LOCK TABLES `ACT_RU_HISTORY_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_HISTORY_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_HISTORY_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_IDENTITYLINK`
--

DROP TABLE IF EXISTS `ACT_RU_IDENTITYLINK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_IDENT_LNK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_IDENT_LNK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `ACT_RU_TASK` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_IDENTITYLINK`
--

LOCK TABLES `ACT_RU_IDENTITYLINK` WRITE;
/*!40000 ALTER TABLE `ACT_RU_IDENTITYLINK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_IDENTITYLINK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_JOB` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CUSTOM_VALUES_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_JOB_EXCEPTION_STACK_ID` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_IDX_JOB_CUSTOM_VALUES_ID` (`CUSTOM_VALUES_ID_`),
  KEY `ACT_IDX_JOB_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_JOB_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_JOB_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_JOB_CUSTOM_VALUES` FOREIGN KEY (`CUSTOM_VALUES_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_JOB`
--

LOCK TABLES `ACT_RU_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_SUSPENDED_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_SUSPENDED_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_SUSPENDED_JOB` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CUSTOM_VALUES_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_SUSPENDED_JOB_EXCEPTION_STACK_ID` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_IDX_SUSPENDED_JOB_CUSTOM_VALUES_ID` (`CUSTOM_VALUES_ID_`),
  KEY `ACT_IDX_SJOB_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_SJOB_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_SJOB_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_CUSTOM_VALUES` FOREIGN KEY (`CUSTOM_VALUES_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_SUSPENDED_JOB`
--

LOCK TABLES `ACT_RU_SUSPENDED_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_SUSPENDED_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_SUSPENDED_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_TASK`
--

DROP TABLE IF EXISTS `ACT_RU_TASK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_TASK` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  `SUB_TASK_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_IDX_TASK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TASK_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TASK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_TASK`
--

LOCK TABLES `ACT_RU_TASK` WRITE;
/*!40000 ALTER TABLE `ACT_RU_TASK` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_TASK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_TIMER_JOB`
--

DROP TABLE IF EXISTS `ACT_RU_TIMER_JOB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_TIMER_JOB` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ELEMENT_NAME_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `CUSTOM_VALUES_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TIMER_JOB_EXCEPTION_STACK_ID` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_IDX_TIMER_JOB_CUSTOM_VALUES_ID` (`CUSTOM_VALUES_ID_`),
  KEY `ACT_IDX_TJOB_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TJOB_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TJOB_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_CUSTOM_VALUES` FOREIGN KEY (`CUSTOM_VALUES_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_TIMER_JOB`
--

LOCK TABLES `ACT_RU_TIMER_JOB` WRITE;
/*!40000 ALTER TABLE `ACT_RU_TIMER_JOB` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_TIMER_JOB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACT_RU_VARIABLE`
--

DROP TABLE IF EXISTS `ACT_RU_VARIABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACT_RU_VARIABLE` (
  `ID_` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_RU_VAR_SCOPE_ID_TYPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_RU_VAR_SUB_ID_TYPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACT_RU_VARIABLE`
--

LOCK TABLES `ACT_RU_VARIABLE` WRITE;
/*!40000 ALTER TABLE `ACT_RU_VARIABLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACT_RU_VARIABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_container_data`
--

DROP TABLE IF EXISTS `candidate_container_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate_container_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_candidate_container` (`id`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='候选人容器';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_container_data`
--

LOCK TABLES `candidate_container_data` WRITE;
/*!40000 ALTER TABLE `candidate_container_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidate_container_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_element_data`
--

DROP TABLE IF EXISTS `candidate_element_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate_element_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `image` varchar(512) CHARACTER SET ascii DEFAULT NULL COMMENT '图片',
  `container` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '容器',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_candidate_element` (`id`,`version`),
  KEY `fk4container_of_candidate_element_data` (`container`),
  CONSTRAINT `fk4container_of_candidate_element_data` FOREIGN KEY (`container`) REFERENCES `candidate_container_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='候选人元素';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_element_data`
--

LOCK TABLES `candidate_element_data` WRITE;
/*!40000 ALTER TABLE `candidate_element_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidate_element_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_data`
--

DROP TABLE IF EXISTS `city_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `province` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `platform` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '平台',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_city` (`id`,`version`),
  KEY `fk4province_of_city_data` (`province`),
  KEY `fk4platform_of_city_data` (`platform`),
  CONSTRAINT `fk4platform_of_city_data` FOREIGN KEY (`platform`) REFERENCES `platform_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4province_of_city_data` FOREIGN KEY (`province`) REFERENCES `province_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='城市';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_data`
--

LOCK TABLES `city_data` WRITE;
/*!40000 ALTER TABLE `city_data` DISABLE KEYS */;
INSERT INTO `city_data` VALUES ('C000001','成都','P000001','P000001',1),('C000002','北京','P000001','P000001',1),('C000003','成都','P000002','P000001',1),('C000004','北京','P000002','P000001',1);
/*!40000 ALTER TABLE `city_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district_data`
--

DROP TABLE IF EXISTS `district_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `city` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `platform` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '平台',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_district` (`id`,`version`),
  KEY `fk4city_of_district_data` (`city`),
  KEY `fk4platform_of_district_data` (`platform`),
  CONSTRAINT `fk4city_of_district_data` FOREIGN KEY (`city`) REFERENCES `city_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4platform_of_district_data` FOREIGN KEY (`platform`) REFERENCES `platform_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='区/县';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district_data`
--

LOCK TABLES `district_data` WRITE;
/*!40000 ALTER TABLE `district_data` DISABLE KEYS */;
INSERT INTO `district_data` VALUES ('D000001','成华区','C000001','P000001',1),('D000002','朝阳区','C000001','P000001',1),('D000003','锦江区','C000002','P000001',1),('D000004','海淀区','C000002','P000001',1),('D000005','成华区','C000003','P000001',1),('D000006','朝阳区','C000003','P000001',1),('D000007','锦江区','C000004','P000001',1),('D000008','海淀区','C000004','P000001',1);
/*!40000 ALTER TABLE `district_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_action_data`
--

DROP TABLE IF EXISTS `form_action_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_action_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `label` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  `locale_key` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '语言环境的关键',
  `action_key` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行动的关键',
  `level` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '水平',
  `url` varchar(168) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'url',
  `form` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '形式',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_form_action` (`id`,`version`),
  KEY `fk4form_of_form_action_data` (`form`),
  CONSTRAINT `fk4form_of_form_action_data` FOREIGN KEY (`form`) REFERENCES `generic_form_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单动作';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_action_data`
--

LOCK TABLES `form_action_data` WRITE;
/*!40000 ALTER TABLE `form_action_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `form_action_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_field_data`
--

DROP TABLE IF EXISTS `form_field_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_field_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `label` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  `locale_key` varchar(44) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '语言环境的关键',
  `parameter_name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参数名称',
  `type` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `form` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '形式',
  `placeholder` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '占位符',
  `default_value` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '默认值',
  `description` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `field_group` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字段组',
  `minimum_value` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最小值',
  `maximum_value` varchar(72) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最大值',
  `required` tinyint(4) DEFAULT NULL COMMENT '要求',
  `disabled` tinyint(4) DEFAULT NULL COMMENT '是否冻结',
  `custom_rendering` tinyint(4) DEFAULT NULL COMMENT '自定义渲染',
  `candidate_values` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '候选人的价值观',
  `suggest_values` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '建议值',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_form_field` (`id`,`version`),
  KEY `fk4form_of_form_field_data` (`form`),
  CONSTRAINT `fk4form_of_form_field_data` FOREIGN KEY (`form`) REFERENCES `generic_form_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_field_data`
--

LOCK TABLES `form_field_data` WRITE;
/*!40000 ALTER TABLE `form_field_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `form_field_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_field_message_data`
--

DROP TABLE IF EXISTS `form_field_message_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_field_message_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `title` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `parameter_name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参数名称',
  `form` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '形式',
  `level` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '水平',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_form_field_message` (`id`,`version`),
  KEY `fk4form_of_form_field_message_data` (`form`),
  CONSTRAINT `fk4form_of_form_field_message_data` FOREIGN KEY (`form`) REFERENCES `generic_form_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单字段的信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_field_message_data`
--

LOCK TABLES `form_field_message_data` WRITE;
/*!40000 ALTER TABLE `form_field_message_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `form_field_message_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_message_data`
--

DROP TABLE IF EXISTS `form_message_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_message_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `title` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `form` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '形式',
  `level` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '水平',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_form_message` (`id`,`version`),
  KEY `fk4form_of_form_message_data` (`form`),
  CONSTRAINT `fk4form_of_form_message_data` FOREIGN KEY (`form`) REFERENCES `generic_form_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_message_data`
--

LOCK TABLES `form_message_data` WRITE;
/*!40000 ALTER TABLE `form_message_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `form_message_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generic_form_data`
--

DROP TABLE IF EXISTS `generic_form_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generic_form_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `title` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `description` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_generic_form` (`id`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='通用的形式';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generic_form_data`
--

LOCK TABLES `generic_form_data` WRITE;
/*!40000 ALTER TABLE `generic_form_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `generic_form_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holyday_setting_data`
--

DROP TABLE IF EXISTS `holyday_setting_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holyday_setting_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `type` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `leave_days` int(11) DEFAULT NULL COMMENT '离开的日子',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_holyday_setting` (`id`,`version`),
  KEY `idx4leave_days_of_holyday_setting` (`leave_days`),
  KEY `fk4type_of_holyday_setting_data` (`type`),
  CONSTRAINT `fk4type_of_holyday_setting_data` FOREIGN KEY (`type`) REFERENCES `leave_record_type_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='宗教节日的设置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holyday_setting_data`
--

LOCK TABLES `holyday_setting_data` WRITE;
/*!40000 ALTER TABLE `holyday_setting_data` DISABLE KEYS */;
INSERT INTO `holyday_setting_data` VALUES ('HS000001','ANNUAL_LEAVE',10,1),('HS000002','PERSONAL_LEAVE',10,1);
/*!40000 ALTER TABLE `holyday_setting_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_lines`
--

DROP TABLE IF EXISTS `info_lines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info_lines` (
  `line` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_lines`
--

LOCK TABLES `info_lines` WRITE;
/*!40000 ALTER TABLE `info_lines` DISABLE KEYS */;
INSERT INTO `info_lines` VALUES ('   SSSSSSSSSSSSSSS                                                                                                                  !!! '),(' SS:::::::::::::::S                                                                                                                !!:!!'),('S:::::SSSSSS::::::S                                                                                                                !:::!'),('S:::::S     SSSSSSS                                                                                                                !:::!'),('S:::::S            uuuuuu    uuuuuu      cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeee        ssssssssss       ssssssssss   !:::!'),('S:::::S            u::::u    u::::u    cc:::::::::::::::c  cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s    ss::::::::::s  !:::!'),(' S::::SSSS         u::::u    u::::u   c:::::::::::::::::c c:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s !:::!'),('  SS::::::SSSSS    u::::u    u::::u  c:::::::cccccc:::::cc:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s!:::!'),('    SSS::::::::SS  u::::u    u::::u  c::::::c     cccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss !:::!'),('       SSSSSS::::S u::::u    u::::u  c:::::c             c:::::c             e:::::::::::::::::e    s::::::s         s::::::s      !:::!'),('            S:::::Su::::u    u::::u  c:::::c             c:::::c             e::::::eeeeeeeeeee        s::::::s         s::::::s   !!:!!'),('            S:::::Su:::::uuuu:::::u  c::::::c     cccccccc::::::c     ccccccce:::::::e           ssssss   s:::::s ssssss   s:::::s  !!! '),('SSSSSSS     S:::::Su:::::::::::::::uuc:::::::cccccc:::::cc:::::::cccccc:::::ce::::::::e          s:::::ssss::::::ss:::::ssss::::::s     '),('S::::::SSSSSS:::::S u:::::::::::::::u c:::::::::::::::::c c:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s  !!! '),('S:::::::::::::::SS   uu::::::::uu:::u  cc:::::::::::::::c  cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss  !!:!!'),(' SSSSSSSSSSSSSSS       uuuuuuuu  uuuu    cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss      sssssssssss     !!! ');
/*!40000 ALTER TABLE `info_lines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_record_data`
--

DROP TABLE IF EXISTS `leave_record_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_record_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `user` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户',
  `type` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  `fromdate` date DEFAULT NULL COMMENT 'Fromdate',
  `todate` date DEFAULT NULL COMMENT '迄今为止,',
  `platform` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '平台',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_leave_record` (`id`,`version`),
  KEY `idx4fromdate_of_leave_record` (`fromdate`),
  KEY `idx4todate_of_leave_record` (`todate`),
  KEY `fk4user_of_leave_record_data` (`user`),
  KEY `fk4type_of_leave_record_data` (`type`),
  KEY `fk4platform_of_leave_record_data` (`platform`),
  CONSTRAINT `fk4platform_of_leave_record_data` FOREIGN KEY (`platform`) REFERENCES `platform_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4type_of_leave_record_data` FOREIGN KEY (`type`) REFERENCES `leave_record_type_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4user_of_leave_record_data` FOREIGN KEY (`user`) REFERENCES `user_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='留下记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_record_data`
--

LOCK TABLES `leave_record_data` WRITE;
/*!40000 ALTER TABLE `leave_record_data` DISABLE KEYS */;
INSERT INTO `leave_record_data` VALUES ('LR000001','U000001','ANNUAL_LEAVE','2017-07-31','2018-04-13','P000001',1),('LR000002','U000001','ANNUAL_LEAVE','2018-03-15','2018-08-02','P000001',1),('LR000003','U000002','ANNUAL_LEAVE','2018-07-16','2019-11-22','P000001',1),('LR000004','U000002','ANNUAL_LEAVE','2019-10-21','2017-11-16','P000001',1),('LR000005','U000003','ANNUAL_LEAVE','2019-11-10','2018-03-22','P000001',1),('LR000006','U000003','ANNUAL_LEAVE','2018-03-31','2019-05-15','P000001',1),('LR000007','U000004','ANNUAL_LEAVE','2017-08-06','2017-07-03','P000001',1),('LR000008','U000004','SICK_LEACK','2020-01-19','2018-03-18','P000001',1),('LR000009','U000005','SICK_LEACK','2019-10-02','2018-12-07','P000001',1),('LR000010','U000005','SICK_LEACK','2017-03-07','2017-08-07','P000001',1),('LR000011','U000006','SICK_LEACK','2019-02-22','2017-09-09','P000001',1),('LR000012','U000006','SICK_LEACK','2018-08-06','2017-11-25','P000001',1),('LR000013','U000007','SICK_LEACK','2019-08-24','2018-08-08','P000001',1),('LR000014','U000007','PERSONAL_LEAVE','2019-03-14','2018-07-22','P000001',1),('LR000015','U000008','PERSONAL_LEAVE','2017-07-18','2017-06-24','P000001',1),('LR000016','U000008','PERSONAL_LEAVE','2017-10-17','2017-05-26','P000001',1),('LR000017','U000009','PERSONAL_LEAVE','2017-12-23','2019-08-08','P000001',1),('LR000018','U000009','PERSONAL_LEAVE','2018-07-20','2019-02-01','P000001',1),('LR000019','U000010','PERSONAL_LEAVE','2018-03-16','2019-07-20','P000001',1),('LR000020','U000010','PERSONAL_LEAVE','2017-10-18','2019-04-30','P000001',1),('LR000021','U000011','MARRIAGE_HOLIDAY','2017-08-10','2017-06-18','P000001',1),('LR000022','U000011','MARRIAGE_HOLIDAY','2017-09-25','2018-03-20','P000001',1),('LR000023','U000012','MARRIAGE_HOLIDAY','2017-12-17','2019-12-07','P000001',1),('LR000024','U000012','MARRIAGE_HOLIDAY','2018-01-03','2019-05-10','P000001',1),('LR000025','U000013','MARRIAGE_HOLIDAY','2019-10-01','2019-02-11','P000001',1),('LR000026','U000013','MARRIAGE_HOLIDAY','2018-09-20','2018-06-22','P000001',1),('LR000027','U000014','MATERNITY_LEAVE','2017-10-09','2020-02-08','P000001',1),('LR000028','U000014','MATERNITY_LEAVE','2017-10-20','2020-02-19','P000001',1),('LR000029','U000015','MATERNITY_LEAVE','2018-06-13','2018-07-30','P000001',1),('LR000030','U000015','MATERNITY_LEAVE','2018-02-25','2017-07-17','P000001',1),('LR000031','U000016','MATERNITY_LEAVE','2018-09-19','2017-06-28','P000001',1),('LR000032','U000016','MATERNITY_LEAVE','2019-05-22','2018-10-03','P000001',1);
/*!40000 ALTER TABLE `leave_record_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_record_type_data`
--

DROP TABLE IF EXISTS `leave_record_type_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_record_type_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `code` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编码',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_leave_record_type` (`id`,`version`),
  UNIQUE KEY `idx4code_of_leave_record_type` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='离开记录类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_record_type_data`
--

LOCK TABLES `leave_record_type_data` WRITE;
/*!40000 ALTER TABLE `leave_record_type_data` DISABLE KEYS */;
INSERT INTO `leave_record_type_data` VALUES ('ANNUAL_LEAVE','年假','ANNUAL_LEAVE',1),('MARRIAGE_HOLIDAY','婚假','MARRIAGE_HOLIDAY',1),('MATERNITY_LEAVE','产假','MATERNITY_LEAVE',1),('PERSONAL_LEAVE','事假','PERSONAL_LEAVE',1),('SICK_LEACK','病假','SICK_LEACK',1);
/*!40000 ALTER TABLE `leave_record_type_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_access_data`
--

DROP TABLE IF EXISTS `list_access_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_access_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `internal_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内部名称',
  `read_permission` tinyint(4) DEFAULT NULL COMMENT '读权限',
  `create_permission` tinyint(4) DEFAULT NULL COMMENT '创建权限',
  `delete_permission` tinyint(4) DEFAULT NULL COMMENT '删除权限',
  `update_permission` tinyint(4) DEFAULT NULL COMMENT '更新权限',
  `execution_permission` tinyint(4) DEFAULT NULL COMMENT '执行权限',
  `app` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用程序',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_list_access` (`id`,`version`),
  KEY `fk4app_of_list_access_data` (`app`),
  CONSTRAINT `fk4app_of_list_access_data` FOREIGN KEY (`app`) REFERENCES `user_app_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='访问列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_access_data`
--

LOCK TABLES `list_access_data` WRITE;
/*!40000 ALTER TABLE `list_access_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_access_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_history_data`
--

DROP TABLE IF EXISTS `login_history_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_history_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `from_ip` varchar(44) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '来自IP',
  `description` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `sec_user` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '安全用户',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_login_history` (`id`,`version`),
  KEY `idx4login_time_of_login_history` (`login_time`),
  KEY `fk4sec_user_of_login_history_data` (`sec_user`),
  CONSTRAINT `fk4sec_user_of_login_history_data` FOREIGN KEY (`sec_user`) REFERENCES `sec_user_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='登录历史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_history_data`
--

LOCK TABLES `login_history_data` WRITE;
/*!40000 ALTER TABLE `login_history_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_history_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_access_data`
--

DROP TABLE IF EXISTS `object_access_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_access_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `object_type` varchar(112) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问对象类型',
  `list1` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表1',
  `list2` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表2',
  `list3` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表3',
  `list4` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表4',
  `list5` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表5',
  `list6` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表6',
  `list7` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表7',
  `list8` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表8',
  `list9` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表9',
  `app` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用程序',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_object_access` (`id`,`version`),
  KEY `fk4app_of_object_access_data` (`app`),
  CONSTRAINT `fk4app_of_object_access_data` FOREIGN KEY (`app`) REFERENCES `user_app_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='对象访问';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_access_data`
--

LOCK TABLES `object_access_data` WRITE;
/*!40000 ALTER TABLE `object_access_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `object_access_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_data`
--

DROP TABLE IF EXISTS `platform_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `founded` datetime DEFAULT NULL COMMENT '成立',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_platform` (`id`,`version`),
  KEY `idx4founded_of_platform` (`founded`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='平台';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_data`
--

LOCK TABLES `platform_data` WRITE;
/*!40000 ALTER TABLE `platform_data` DISABLE KEYS */;
INSERT INTO `platform_data` VALUES ('P000001','EHR','2020-02-13 21:24:34',1);
/*!40000 ALTER TABLE `platform_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province_data`
--

DROP TABLE IF EXISTS `province_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `platform` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '平台',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_province` (`id`,`version`),
  KEY `fk4platform_of_province_data` (`platform`),
  CONSTRAINT `fk4platform_of_province_data` FOREIGN KEY (`platform`) REFERENCES `platform_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='省';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province_data`
--

LOCK TABLES `province_data` WRITE;
/*!40000 ALTER TABLE `province_data` DISABLE KEYS */;
INSERT INTO `province_data` VALUES ('P000001','四川','P000001',1),('P000002','北京','P000001',1);
/*!40000 ALTER TABLE `province_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quick_link_data`
--

DROP TABLE IF EXISTS `quick_link_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quick_link_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `icon` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `image_path` varchar(512) CHARACTER SET ascii DEFAULT NULL COMMENT '图片路径',
  `link_target` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '链接的目标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `app` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用程序',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_quick_link` (`id`,`version`),
  KEY `idx4create_time_of_quick_link` (`create_time`),
  KEY `fk4app_of_quick_link_data` (`app`),
  CONSTRAINT `fk4app_of_quick_link_data` FOREIGN KEY (`app`) REFERENCES `user_app_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='快速链接';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quick_link_data`
--

LOCK TABLES `quick_link_data` WRITE;
/*!40000 ALTER TABLE `quick_link_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `quick_link_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_data`
--

DROP TABLE IF EXISTS `role_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `code` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编码',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_role` (`id`,`version`),
  UNIQUE KEY `idx4code_of_role` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_data`
--

LOCK TABLES `role_data` WRITE;
/*!40000 ALTER TABLE `role_data` DISABLE KEYS */;
INSERT INTO `role_data` VALUES ('BOSS','老板','BOSS',1),('EMPLOYEE','员工','EMPLOYEE',1),('MANAGER','主管','MANAGER',1);
/*!40000 ALTER TABLE `role_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_user_data`
--

DROP TABLE IF EXISTS `sec_user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_user_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `login` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录',
  `mobile` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `email` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `pwd` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `weixin_openid` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信openid',
  `weixin_appid` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信Appid',
  `access_token` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问令牌',
  `verification_code` int(11) DEFAULT NULL COMMENT '验证码',
  `verification_code_expire` datetime DEFAULT NULL COMMENT '验证码过期',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `domain` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_sec_user` (`id`,`version`),
  UNIQUE KEY `idx4login_of_sec_user` (`login`),
  UNIQUE KEY `idx4email_of_sec_user` (`email`),
  UNIQUE KEY `idx4mobile_of_sec_user` (`mobile`),
  KEY `idx4verification_code_of_sec_user` (`verification_code`),
  KEY `idx4verification_code_expire_of_sec_user` (`verification_code_expire`),
  KEY `idx4last_login_time_of_sec_user` (`last_login_time`),
  KEY `fk4domain_of_sec_user_data` (`domain`),
  CONSTRAINT `fk4domain_of_sec_user_data` FOREIGN KEY (`domain`) REFERENCES `user_domain_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='安全用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_user_data`
--

LOCK TABLES `sec_user_data` WRITE;
/*!40000 ALTER TABLE `sec_user_data` DISABLE KEYS */;
INSERT INTO `sec_user_data` VALUES ('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246','weixin_openid_000001','weixin_appid_000001','jwt_token_000001',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C','weixin_openid_000002','weixin_appid_000002','jwt_token_000002',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA','weixin_openid_000003','weixin_appid_000003','jwt_token_000003',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28','weixin_openid_000004','weixin_appid_000004','jwt_token_000004',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C','weixin_openid_000005','weixin_appid_000005','jwt_token_000005',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55','weixin_openid_000006','weixin_appid_000006','jwt_token_000006',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803','weixin_openid_000007','weixin_appid_000007','jwt_token_000007',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000008','User000008','13900000008','1000008@qq.com','A4B83C2652CD6BECE5C7909576555B313078D7EE50AA028F26B8F0245C191B4B','weixin_openid_000008','weixin_appid_000008','jwt_token_000008',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000009','User000009','13900000009','1000009@qq.com','88F8AB5F153081C5AB21F5E5354B4EB14286EFB43CEA588ED1C73FE2B46B35C1','weixin_openid_000009','weixin_appid_000009','jwt_token_000009',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000010','User000010','13900000010','1000010@qq.com','EF8232ABB97CC3858F271527A1AA1452A33715A3AC48312A44B0940D5C948600','weixin_openid_000010','weixin_appid_000010','jwt_token_000010',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000011','User000011','13900000011','1000011@qq.com','FE7AF5D4F030CD575C117A73124FC39AB41528DFFC41D2CFBC1130E755694243','weixin_openid_000011','weixin_appid_000011','jwt_token_000011',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000012','User000012','13900000012','1000012@qq.com','999DD89E35807C62458F2D191D4F55548B49245EEC6E186FE9497EC867C40088','weixin_openid_000012','weixin_appid_000012','jwt_token_000012',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000013','User000013','13900000013','1000013@qq.com','0AE92E17166CBB59341836C218E92EF083058CC4E3108C5FD2FB904650013A69','weixin_openid_000013','weixin_appid_000013','jwt_token_000013',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000014','User000014','13900000014','1000014@qq.com','E79E64241204EB0FCE03C4BA0E315F21ECDB11D22264BE7B1AAD41D04D77A6D0','weixin_openid_000014','weixin_appid_000014','jwt_token_000014',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000015','User000015','13900000015','1000015@qq.com','1D858671B95062DAFE1D989C089188CC4EFDF3D5C45D8F24DD20BF3E352A3D9B','weixin_openid_000015','weixin_appid_000015','jwt_token_000015',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000016','User000016','13900000016','1000016@qq.com','14B1F5E667F8B6697C8A2952C3619D9AD82F846E5B32FD9F258918786B3ED519','weixin_openid_000016','weixin_appid_000016','jwt_token_000016',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1),('SU000017','User000017','13900000017','1000017@qq.com','1A803C7096681FC2AA7C55C46A6A99D8089481B96997774EA5B1C785C8035010','weixin_openid_000017','weixin_appid_000017','jwt_token_000017',9292993,'2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
/*!40000 ALTER TABLE `sec_user_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_app_data`
--

DROP TABLE IF EXISTS `user_app_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_app_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `title` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `sec_user` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '安全用户',
  `app_icon` varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用程序图标',
  `full_access` tinyint(4) DEFAULT NULL COMMENT '完全访问',
  `permission` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '许可',
  `object_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问对象类型',
  `object_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对象ID',
  `location` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '位置',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_user_app` (`id`,`version`),
  KEY `idx4object_id_of_user_app` (`object_id`),
  KEY `fk4sec_user_of_user_app_data` (`sec_user`),
  CONSTRAINT `fk4sec_user_of_user_app_data` FOREIGN KEY (`sec_user`) REFERENCES `sec_user_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户应用程序';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_app_data`
--

LOCK TABLES `user_app_data` WRITE;
/*!40000 ALTER TABLE `user_app_data` DISABLE KEYS */;
INSERT INTO `user_app_data` VALUES ('UA000001','EHR','SU000001','university',1,'MXWR','Platform','P000001','/link/to/app',1),('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app',1),('UA000003','用户管理','SU000001','users',1,'MXWR','UserDomain','UD000001','/link/to/app',1),('UA000004','用户: 王大锤','SU000002','store',1,'MXWR','User','U000001','/link/to/app',1),('UA000005','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app',1),('UA000006','用户: 王大锤0002','SU000003','store',1,'MXWR','User','U000002','/link/to/app',1),('UA000007','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app',1),('UA000008','用户: 王大锤0003','SU000004','store',1,'MXWR','User','U000003','/link/to/app',1),('UA000009','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app',1),('UA000010','用户: 王大锤0004','SU000005','store',1,'MXWR','User','U000004','/link/to/app',1),('UA000011','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app',1),('UA000012','用户: 王大锤0005','SU000006','store',1,'MXWR','User','U000005','/link/to/app',1),('UA000013','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app',1),('UA000014','用户: 王大锤0006','SU000007','store',1,'MXWR','User','U000006','/link/to/app',1),('UA000015','我的账户','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app',1),('UA000016','用户: 王大锤0007','SU000008','store',1,'MXWR','User','U000007','/link/to/app',1),('UA000017','我的账户','SU000008','lock',1,'MXWR','SecUser','SU000008','/link/to/app',1),('UA000018','用户: 王大锤0008','SU000009','store',1,'MXWR','User','U000008','/link/to/app',1),('UA000019','我的账户','SU000009','lock',1,'MXWR','SecUser','SU000009','/link/to/app',1),('UA000020','用户: 王大锤0009','SU000010','store',1,'MXWR','User','U000009','/link/to/app',1),('UA000021','我的账户','SU000010','lock',1,'MXWR','SecUser','SU000010','/link/to/app',1),('UA000022','用户: 王大锤0010','SU000011','store',1,'MXWR','User','U000010','/link/to/app',1),('UA000023','我的账户','SU000011','lock',1,'MXWR','SecUser','SU000011','/link/to/app',1),('UA000024','用户: 王大锤0011','SU000012','store',1,'MXWR','User','U000011','/link/to/app',1),('UA000025','我的账户','SU000012','lock',1,'MXWR','SecUser','SU000012','/link/to/app',1),('UA000026','用户: 王大锤0012','SU000013','store',1,'MXWR','User','U000012','/link/to/app',1),('UA000027','我的账户','SU000013','lock',1,'MXWR','SecUser','SU000013','/link/to/app',1),('UA000028','用户: 王大锤0013','SU000014','store',1,'MXWR','User','U000013','/link/to/app',1),('UA000029','我的账户','SU000014','lock',1,'MXWR','SecUser','SU000014','/link/to/app',1),('UA000030','用户: 王大锤0014','SU000015','store',1,'MXWR','User','U000014','/link/to/app',1),('UA000031','我的账户','SU000015','lock',1,'MXWR','SecUser','SU000015','/link/to/app',1),('UA000032','用户: 王大锤0015','SU000016','store',1,'MXWR','User','U000015','/link/to/app',1),('UA000033','我的账户','SU000016','lock',1,'MXWR','SecUser','SU000016','/link/to/app',1),('UA000034','用户: 王大锤0016','SU000017','store',1,'MXWR','User','U000016','/link/to/app',1),('UA000035','我的账户','SU000017','lock',1,'MXWR','SecUser','SU000017','/link/to/app',1);
/*!40000 ALTER TABLE `user_app_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `mobile` varchar(44) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(28) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `description` longtext COLLATE utf8mb4_unicode_ci COMMENT '描述',
  `district` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区/县',
  `role` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_user` (`id`,`version`),
  KEY `idx4mobile_of_user` (`mobile`),
  KEY `idx4age_of_user` (`age`),
  KEY `fk4district_of_user_data` (`district`),
  KEY `fk4role_of_user_data` (`role`),
  CONSTRAINT `fk4district_of_user_data` FOREIGN KEY (`district`) REFERENCES `district_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4role_of_user_data` FOREIGN KEY (`role`) REFERENCES `role_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_data`
--

LOCK TABLES `user_data` WRITE;
/*!40000 ALTER TABLE `user_data` DISABLE KEYS */;
INSERT INTO `user_data` VALUES ('U000001','王大锤','13987654321','image()',18,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE',1),('U000002','王大锤0002','13900000002','image()0002',19,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000001','EMPLOYEE',1),('U000003','王大锤0003','13900000003','image()0003',24,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE',1),('U000004','王大锤0004','13900000004','image()0004',19,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000002','EMPLOYEE',1),('U000005','王大锤0005','13900000005','image()0005',23,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE',1),('U000006','王大锤0006','13900000006','image()0006',19,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000003','EMPLOYEE',1),('U000007','王大锤0007','13900000007','image()0007',24,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER',1),('U000008','王大锤0008','13900000008','image()0008',20,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000004','MANAGER',1),('U000009','王大锤0009','13900000009','image()0009',25,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER',1),('U000010','王大锤0010','13900000010','image()0010',23,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000005','MANAGER',1),('U000011','王大锤0011','13900000011','image()0011',25,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','MANAGER',1),('U000012','王大锤0012','13900000012','image()0012',21,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000006','BOSS',1),('U000013','王大锤0013','13900000013','image()0013',25,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS',1),('U000014','王大锤0014','13900000014','image()0014',24,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000007','BOSS',1),('U000015','王大锤0015','13900000015','image()0015',23,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS',1),('U000016','王大锤0016','13900000016','image()0016',18,'    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','D000008','BOSS',1);
/*!40000 ALTER TABLE `user_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_domain_data`
--

DROP TABLE IF EXISTS `user_domain_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_domain_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_user_domain` (`id`,`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户域';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_domain_data`
--

LOCK TABLES `user_domain_data` WRITE;
/*!40000 ALTER TABLE `user_domain_data` DISABLE KEYS */;
INSERT INTO `user_domain_data` VALUES ('UD000001','用户区域',1);
/*!40000 ALTER TABLE `user_domain_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_white_list_data`
--

DROP TABLE IF EXISTS `user_white_list_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_white_list_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `user_identity` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户身份',
  `user_special_functions` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户特殊功能',
  `domain` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_user_white_list` (`id`,`version`),
  KEY `fk4domain_of_user_white_list_data` (`domain`),
  CONSTRAINT `fk4domain_of_user_white_list_data` FOREIGN KEY (`domain`) REFERENCES `user_domain_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户白名单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_white_list_data`
--

LOCK TABLES `user_white_list_data` WRITE;
/*!40000 ALTER TABLE `user_white_list_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_white_list_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wechat_miniapp_identify_data`
--

DROP TABLE IF EXISTS `wechat_miniapp_identify_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wechat_miniapp_identify_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `open_id` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '开放Id',
  `app_id` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用程序Id',
  `sec_user` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '安全用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_wechat_miniapp_identify` (`id`,`version`),
  KEY `idx4open_id_of_wechat_miniapp_identify` (`open_id`),
  KEY `idx4app_id_of_wechat_miniapp_identify` (`app_id`),
  KEY `idx4create_time_of_wechat_miniapp_identify` (`create_time`),
  KEY `idx4last_login_time_of_wechat_miniapp_identify` (`last_login_time`),
  KEY `fk4sec_user_of_wechat_miniapp_identify_data` (`sec_user`),
  CONSTRAINT `fk4sec_user_of_wechat_miniapp_identify_data` FOREIGN KEY (`sec_user`) REFERENCES `sec_user_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信Miniapp识别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wechat_miniapp_identify_data`
--

LOCK TABLES `wechat_miniapp_identify_data` WRITE;
/*!40000 ALTER TABLE `wechat_miniapp_identify_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wechat_miniapp_identify_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wechat_workapp_identify_data`
--

DROP TABLE IF EXISTS `wechat_workapp_identify_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wechat_workapp_identify_data` (
  `id` varchar(48) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `corp_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司标识',
  `user_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户Id',
  `sec_user` varchar(48) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '安全用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx4id_ver_of_wechat_workapp_identify` (`id`,`version`),
  KEY `idx4corp_id_of_wechat_workapp_identify` (`corp_id`),
  KEY `idx4user_id_of_wechat_workapp_identify` (`user_id`),
  KEY `idx4create_time_of_wechat_workapp_identify` (`create_time`),
  KEY `idx4last_login_time_of_wechat_workapp_identify` (`last_login_time`),
  KEY `fk4sec_user_of_wechat_workapp_identify_data` (`sec_user`),
  CONSTRAINT `fk4sec_user_of_wechat_workapp_identify_data` FOREIGN KEY (`sec_user`) REFERENCES `sec_user_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信Workapp识别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wechat_workapp_identify_data`
--

LOCK TABLES `wechat_workapp_identify_data` WRITE;
/*!40000 ALTER TABLE `wechat_workapp_identify_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `wechat_workapp_identify_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-25 11:31:48
