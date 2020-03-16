use flowable;
SET FOREIGN_KEY_CHECKS=0;
alter table ACT_APP_APPDEF convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_APP_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;      
alter table ACT_APP_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin;  
alter table ACT_APP_DEPLOYMENT convert to character set utf8mb4 collate utf8mb4_bin;             
alter table ACT_APP_DEPLOYMENT_RESOURCE convert to character set utf8mb4 collate utf8mb4_bin;    
alter table ACT_CMMN_CASEDEF convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_CMMN_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;     
alter table ACT_CMMN_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin; 
alter table ACT_CMMN_DEPLOYMENT convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_CMMN_DEPLOYMENT_RESOURCE convert to character set utf8mb4 collate utf8mb4_bin;   
alter table ACT_CMMN_HI_CASE_INST convert to character set utf8mb4 collate utf8mb4_bin;          
alter table ACT_CMMN_HI_MIL_INST convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_CMMN_HI_PLAN_ITEM_INST convert to character set utf8mb4 collate utf8mb4_bin;     
alter table ACT_CMMN_RU_CASE_INST convert to character set utf8mb4 collate utf8mb4_bin;          
alter table ACT_CMMN_RU_MIL_INST convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_CMMN_RU_PLAN_ITEM_INST convert to character set utf8mb4 collate utf8mb4_bin;     
alter table ACT_CMMN_RU_SENTRY_PART_INST convert to character set utf8mb4 collate utf8mb4_bin;   
alter table ACT_CO_CONTENT_ITEM convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_CO_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;       
alter table ACT_CO_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin;   
alter table ACT_DE_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;       
alter table ACT_DE_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin;   
alter table ACT_DE_MODEL convert to character set utf8mb4 collate utf8mb4_bin;                   
alter table ACT_DE_MODEL_HISTORY convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_DE_MODEL_RELATION convert to character set utf8mb4 collate utf8mb4_bin;          
alter table ACT_DMN_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;      
alter table ACT_DMN_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin;  
alter table ACT_DMN_DECISION_TABLE convert to character set utf8mb4 collate utf8mb4_bin;         
alter table ACT_DMN_DEPLOYMENT convert to character set utf8mb4 collate utf8mb4_bin;             
alter table ACT_DMN_DEPLOYMENT_RESOURCE convert to character set utf8mb4 collate utf8mb4_bin;    
alter table ACT_DMN_HI_DECISION_EXECUTION convert to character set utf8mb4 collate utf8mb4_bin;  
alter table ACT_EVT_LOG convert to character set utf8mb4 collate utf8mb4_bin;                    
alter table ACT_FO_DATABASECHANGELOG convert to character set utf8mb4 collate utf8mb4_bin;       
alter table ACT_FO_DATABASECHANGELOGLOCK convert to character set utf8mb4 collate utf8mb4_bin;   
alter table ACT_FO_FORM_DEFINITION convert to character set utf8mb4 collate utf8mb4_bin;         
alter table ACT_FO_FORM_DEPLOYMENT convert to character set utf8mb4 collate utf8mb4_bin;         
alter table ACT_FO_FORM_INSTANCE convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_FO_FORM_RESOURCE convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_GE_BYTEARRAY convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_GE_PROPERTY convert to character set utf8mb4 collate utf8mb4_bin;                
alter table ACT_HI_ACTINST convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_HI_ATTACHMENT convert to character set utf8mb4 collate utf8mb4_bin;              
alter table ACT_HI_COMMENT convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_HI_DETAIL convert to character set utf8mb4 collate utf8mb4_bin;                  
alter table ACT_HI_ENTITYLINK convert to character set utf8mb4 collate utf8mb4_bin;              
alter table ACT_HI_IDENTITYLINK convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_HI_PROCINST convert to character set utf8mb4 collate utf8mb4_bin;                
alter table ACT_HI_TASKINST convert to character set utf8mb4 collate utf8mb4_bin;                
alter table ACT_HI_TSK_LOG convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_HI_VARINST convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_ID_BYTEARRAY convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_ID_GROUP convert to character set utf8mb4 collate utf8mb4_bin;                   
alter table ACT_ID_INFO convert to character set utf8mb4 collate utf8mb4_bin;                    
alter table ACT_ID_MEMBERSHIP convert to character set utf8mb4 collate utf8mb4_bin;              
alter table ACT_ID_PRIV convert to character set utf8mb4 collate utf8mb4_bin;                    
alter table ACT_ID_PRIV_MAPPING convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_ID_PROPERTY convert to character set utf8mb4 collate utf8mb4_bin;                
alter table ACT_ID_TOKEN convert to character set utf8mb4 collate utf8mb4_bin;                   
alter table ACT_ID_USER convert to character set utf8mb4 collate utf8mb4_bin;                    
alter table ACT_PROCDEF_INFO convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_RE_DEPLOYMENT convert to character set utf8mb4 collate utf8mb4_bin;              
alter table ACT_RE_MODEL convert to character set utf8mb4 collate utf8mb4_bin;                   
alter table ACT_RE_PROCDEF convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_RU_ACTINST convert to character set utf8mb4 collate utf8mb4_bin;                 
alter table ACT_RU_DEADLETTER_JOB convert to character set utf8mb4 collate utf8mb4_bin;          
alter table ACT_RU_ENTITYLINK convert to character set utf8mb4 collate utf8mb4_bin;              
alter table ACT_RU_EVENT_SUBSCR convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_RU_EXECUTION convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_RU_HISTORY_JOB convert to character set utf8mb4 collate utf8mb4_bin;             
alter table ACT_RU_IDENTITYLINK convert to character set utf8mb4 collate utf8mb4_bin;            
alter table ACT_RU_JOB convert to character set utf8mb4 collate utf8mb4_bin;                     
alter table ACT_RU_SUSPENDED_JOB convert to character set utf8mb4 collate utf8mb4_bin;           
alter table ACT_RU_TASK convert to character set utf8mb4 collate utf8mb4_bin;                    
alter table ACT_RU_TIMER_JOB convert to character set utf8mb4 collate utf8mb4_bin;               
alter table ACT_RU_VARIABLE convert to character set utf8mb4 collate utf8mb4_bin; 
SET FOREIGN_KEY_CHECKS=1; 
