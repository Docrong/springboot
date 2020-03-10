select *
from EQUIPMENTNETWORK_MAIN;
select *
from EQUIPMENTNETWORK_LINK;
select *
from EQUIPMENTNETWORK_TASK;

select *
from COMMONTASK_MAIN;

select *
from EquipmentNetwork_main equipmentn0_
where equipmentn0_.sheetId = 'HB-001-20200306-1-10001';

SELECT *
FROM equipmentnetwork_deviceInfo
WHERE 1 = 1
  and deleted = '0';
--
SELECT *
FROM equipmentnetwork_deviceInfo
WHERE 1 = 1
  and deleted = '0'
  and EomsOrderNo = 'HB-001-20200306-1-10001'
  and Action = '3'
  and Prefecture = '地市'
  and County = '区县'
  and DeviceName = '设备名称'
  and DeviceId = '设备ID'
  and DeviceIp = '设备IP';

-- alter table EQUIPMENTNETWORK_DEVICEINFO add (Projectcode varchar2(500),BRANCHUNIT varchar2(500))

select * from complaint_RequestRecord