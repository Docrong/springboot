select *
from mobile_networkelement;
select *
from mobile_person;


select *
from mobile_networkelement t
where cast(t.longitude as decimal(20, 15)) > 30.566511141507444
  and cast(t.longitude as decimal(20, 15)) < 30.61668289931301
  and cast(t.latitude as decimal(20, 15)) > 114.21730804347209
  and cast(t.latitude as decimal(20, 15)) < 114.33883034289924;

select * from mobile_networkelement t where cast(t.longitude as DECIMAL (20,15))>114.22698598464963 and cast(t.longitude as decimal (20,15))<114.33049810222178 and cast(t.latitude as decimal (20,15))>30.580339532053877 and cast(t.latitude as decimal (20,15))<30.609158113116706