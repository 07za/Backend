## announcementChange

GET http://localhost:8000/bid/bidding/announcementChange/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 2,
      "title": "政府采购信息系统升级公告",
      "publisher": "浙江省财政厅",
      "publishDate": "2023-09-04",
      "viewCount": 200,
      "content": "为提升采购管理效率，政府采购系统将于9月10日进行升级。"
    },
    {
      "id": 1,
      "title": "关于道路维护项目调整公告",
      "publisher": "绍兴市交通局",
      "publishDate": "2023-08-31",
      "viewCount": 150,
      "content": "因施工计划调整，原定施工时间将顺延一周，具体时间另行通知。"
    }
  ]
}
```


GET http://localhost:8000/bid/bidding/announcementChange/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "title": "关于道路维护项目调整公告",
    "publisher": "绍兴市交通局",
    "publishDate": "2023-08-31",
    "viewCount": 151,
    "content": "因施工计划调整，原定施工时间将顺延一周，具体时间另行通知。"
  }
}
```


## carousel

GET http://localhost:8000/carousel/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "imageUrl": "img/carousel/1.png",
      "remark": "轮播图1",
      "createTime": "2025-03-13 02:43:09",
      "updateTime": "2025-03-13 02:43:09"
    },
    {
      "id": 2,
      "imageUrl": "img/carousel/2.png",
      "remark": "轮播图2",
      "createTime": "2025-03-13 02:43:09",
      "updateTime": "2025-03-13 02:43:09"
    },
    {
      "id": 3,
      "imageUrl": "img/carousel/3.png",
      "remark": "轮播图3",
      "createTime": "2025-03-13 02:43:09",
      "updateTime": "2025-03-13 02:43:09"
    }
  ]
}
```


GET http://localhost:8000/carousel/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "imageUrl": "img/carousel/1.png",
    "remark": "轮播图1",
    "createTime": "2025-03-13 02:43:09",
    "updateTime": "2025-03-13 02:43:09"
  }
}
```

add file upload
@PostMapping
public Result add(@RequestParam("file") MultipartFile file, String remark)


update file upload
@PutMapping("/{id}")
public Result update(@PathVariable Integer id,
@RequestParam(value = "file", required = false) MultipartFile file,
String remark)


DELETE http://localhost:8000/carousel/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": "删除成功"
}
```

## enterprise

PUT http://localhost:8000/enterprise/update
Content-Type: application/json


{
"id": 2,
"logo": "",
"businessLicense": "",
"name": "abc",
"creditCode": "",
"registeredAddress": "",
"registeredCapital": 0,
"enterpriseType": "",
"establishmentDate": "",
"legalRepresentative": "",
"legalRepresentativeIdCard": "",
"legalRepresentativeIdCardScan": "",
"businessLicenseValidity": "",
"businessScope": "",
"contactPhone": "",
"accountLicenseScan": "",
"bankName": "",
"bankAccount": "",
"bankAddress": "",
"auditStatus": ""
}

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```


PUT http://localhost:8000/enterprise/updateAuditStatus/1
Content-Type: application/x-www-form-urlencoded

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```


## inspectionStandard

GET http://localhost:8000/inspectionStandard/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "checkDate": "2025-03-12 02:00:00",
      "checkItemName": "蛋白质含量",
      "checkQuantity": 100.0,
      "checkResult": "合格",
      "checkStandardId": 101,
      "checkUser": "张三",
      "checkValue": 18.5,
      "materialBatchNo": "BATCH2025031201",
      "maxValue": 20.0,
      "minValue": 15.0,
      "createTime": "2025-03-13T02:44:56.000+00:00",
      "updateTime": "2025-03-13T02:44:56.000+00:00"
    },
    {
      "id": 2,
      "checkDate": "2025-03-12 02:30:00",
      "checkItemName": "水分含量",
      "checkQuantity": 80.0,
      "checkResult": "不合格",
      "checkStandardId": 102,
      "checkUser": "李四",
      "checkValue": 12.0,
      "materialBatchNo": "BATCH2025031202",
      "maxValue": 10.0,
      "minValue": 5.0,
      "createTime": "2025-03-13T02:44:56.000+00:00",
      "updateTime": "2025-03-13T02:44:56.000+00:00"
    }
  ]
}
```

## mesCheck/materialCheck

GET http://localhost:8000/mesCheck/materialCheck/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "checkDate": "2025-03-12 01:30:00",
      "checkItemName": "硬度测试",
      "checkQuantity": 50.0,
      "checkResult": 1,
      "checkStandardId": 1001,
      "checkUser": "张三",
      "checkValue": 7.5,
      "createBy": "admin",
      "materialCode": "MAT2025031201",
      "materialId": 2001,
      "materialModel": "XJ-100",
      "materialName": "铝合金板",
      "materialRequisitionId": 3001,
      "materialRequisitionNo": "REQ2025031201",
      "materialSpecification": "10mm厚",
      "materialUnit": "张",
      "maxValue": 10.0,
      "minValue": 5.0,
      "receiveQuantity": 48.0,
      "requireQuantity": 50.0,
      "serialNo": "SN2025031201",
      "remark": "符合标准",
      "updateBy": "李四",
      "updateTime": "2025-03-12T02:00:00.000+00:00"
    },
    {
      "id": 2,
      "checkDate": "2025-03-12 02:00:00",
      "checkItemName": "耐高温测试",
      "checkQuantity": 30.0,
      "checkResult": 0,
      "checkStandardId": 1002,
      "checkUser": "李四",
      "checkValue": 600.0,
      "createBy": "admin",
      "materialCode": "MAT2025031202",
      "materialId": 2002,
      "materialModel": "HG-500",
      "materialName": "耐火砖",
      "materialRequisitionId": 3002,
      "materialRequisitionNo": "REQ2025031202",
      "materialSpecification": "耐温1000℃",
      "materialUnit": "块",
      "maxValue": 800.0,
      "minValue": 500.0,
      "receiveQuantity": 30.0,
      "requireQuantity": 35.0,
      "serialNo": "SN2025031202",
      "remark": "耐温未达标",
      "updateBy": "王五",
      "updateTime": "2025-03-12T02:30:00.000+00:00"
    }
  ]
}
```

GET http://localhost:8000/mesCheck/materialCheck/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "checkDate": "2025-03-12 01:30:00",
    "checkItemName": "硬度测试",
    "checkQuantity": 50.0,
    "checkResult": 1,
    "checkStandardId": 1001,
    "checkUser": "张三",
    "checkValue": 7.5,
    "createBy": "admin",
    "materialCode": "MAT2025031201",
    "materialId": 2001,
    "materialModel": "XJ-100",
    "materialName": "铝合金板",
    "materialRequisitionId": 3001,
    "materialRequisitionNo": "REQ2025031201",
    "materialSpecification": "10mm厚",
    "materialUnit": "张",
    "maxValue": 10.0,
    "minValue": 5.0,
    "receiveQuantity": 48.0,
    "requireQuantity": 50.0,
    "serialNo": "SN2025031201",
    "remark": "符合标准",
    "updateBy": "李四",
    "updateTime": "2025-03-12T02:00:00.000+00:00"
  }
}
```

POST http://localhost:8000/mesCheck/materialCheck
Content-Type: application/json

{
"id": 0,
"checkDate": "",
"checkItemName": "",
"checkQuantity": 0,
"checkResult": 0,
"checkStandardId": 0,
"checkUser": "",
"checkValue": 0,
"createBy": "",
"materialCode": "",
"materialId": 0,
"materialModel": "",
"materialName": "",
"materialRequisitionId": 0,
"materialRequisitionNo": "",
"materialSpecification": "",
"materialUnit": "",
"maxValue": 0,
"minValue": 0,
"receiveQuantity": 0,
"requireQuantity": 0,
"serialNo": "",
"remark": "",
"updateBy": "",
"updateTime": ""
}

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```

PUT http://localhost:8000/mesCheck/materialCheck
Content-Type: application/json

{
"id": 1,
"checkDate": "",
"checkItemName": "ABC",
"checkQuantity": 0,
"checkResult": 0,
"checkStandardId": 0,
"checkUser": "",
"checkValue": 0,
"createBy": "",
"materialCode": "",
"materialId": 0,
"materialModel": "",
"materialName": "",
"materialRequisitionId": 0,
"materialRequisitionNo": "",
"materialSpecification": "",
"materialUnit": "",
"maxValue": 0,
"minValue": 0,
"receiveQuantity": 0,
"requireQuantity": 0,
"serialNo": "",
"remark": "",
"updateBy": "",
"updateTime": ""
}

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```


DELETE http://localhost:8000/mesCheck/materialCheck/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```
## mesCheck/productCheck

GET http://localhost:8000/mesCheck/productCheck/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "checkDate": "2025-03-11",
      "checkItemName": "外观检查",
      "checkQuantity": 10.0,
      "checkResult": "合格",
      "checkStandardId": 1001,
      "checkUser": "张三",
      "checkValue": 95.5,
      "createBy": "admin",
      "materialBatchNo": "Batch001",
      "materialCode": "MAT001",
      "materialId": 1,
      "materialModel": "ModelA",
      "materialName": "产品A",
      "materialSpecification": "规格1",
      "materialUnit": "件",
      "maxValue": 100.0,
      "minValue": 90.0,
      "productDate": "2025-03-10",
      "productFinishId": 1001,
      "productFinishNo": "PF001",
      "productJobId": 2001,
      "productJobName": "作业1",
      "productLineId": 3001,
      "productLineName": "生产线1",
      "productPlanId": 4001,
      "productPlanNo": "计划1",
      "productQuantity": 100.0,
      "productScheduleId": 5001,
      "qualifiedRate": 95.0,
      "remark": "合格率很高",
      "searchValue": "",
      "serialNo": "SN001",
      "updateBy": "admin",
      "updateTime": "2025-03-11 02:05:00",
      "params": "{\"key\": \"value\"}"
    },
    {
      "id": 2,
      "checkDate": "2025-03-11",
      "checkItemName": "尺寸测量",
      "checkQuantity": 5.0,
      "checkResult": "不合格",
      "checkStandardId": 1002,
      "checkUser": "李四",
      "checkValue": 85.0,
      "createBy": "admin",
      "materialBatchNo": "Batch002",
      "materialCode": "MAT002",
      "materialId": 2,
      "materialModel": "ModelB",
      "materialName": "产品B",
      "materialSpecification": "规格2",
      "materialUnit": "米",
      "maxValue": 120.0,
      "minValue": 80.0,
      "productDate": "2025-03-10",
      "productFinishId": 1002,
      "productFinishNo": "PF002",
      "productJobId": 2002,
      "productJobName": "作业2",
      "productLineId": 3002,
      "productLineName": "生产线2",
      "productPlanId": 4002,
      "productPlanNo": "计划2",
      "productQuantity": 200.0,
      "productScheduleId": 5002,
      "qualifiedRate": 80.0,
      "remark": "尺寸不合格",
      "searchValue": "",
      "serialNo": "SN002",
      "updateBy": "admin",
      "updateTime": "2025-03-11 03:05:00",
      "params": "{\"key2\": \"value2\"}"
    },
    {
      "id": 3,
      "checkDate": "2025-03-11",
      "checkItemName": "性能测试",
      "checkQuantity": 20.0,
      "checkResult": "合格",
      "checkStandardId": 1003,
      "checkUser": "王五",
      "checkValue": 98.0,
      "createBy": "admin",
      "materialBatchNo": "Batch003",
      "materialCode": "MAT003",
      "materialId": 3,
      "materialModel": "ModelC",
      "materialName": "产品C",
      "materialSpecification": "规格3",
      "materialUnit": "套",
      "maxValue": 110.0,
      "minValue": 95.0,
      "productDate": "2025-03-10",
      "productFinishId": 1003,
      "productFinishNo": "PF003",
      "productJobId": 2003,
      "productJobName": "作业3",
      "productLineId": 3003,
      "productLineName": "生产线3",
      "productPlanId": 4003,
      "productPlanNo": "计划3",
      "productQuantity": 300.0,
      "productScheduleId": 5003,
      "qualifiedRate": 99.0,
      "remark": "性能良好",
      "searchValue": "",
      "serialNo": "SN003",
      "updateBy": "admin",
      "updateTime": "2025-03-11 04:05:00",
      "params": "{\"key3\": \"value3\"}"
    }
  ]
}
```

GET http://localhost:8000/mesCheck/productCheck/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "checkDate": "2025-03-11",
    "checkItemName": "外观检查",
    "checkQuantity": 10.0,
    "checkResult": "合格",
    "checkStandardId": 1001,
    "checkUser": "张三",
    "checkValue": 95.5,
    "createBy": "admin",
    "materialBatchNo": "Batch001",
    "materialCode": "MAT001",
    "materialId": 1,
    "materialModel": "ModelA",
    "materialName": "产品A",
    "materialSpecification": "规格1",
    "materialUnit": "件",
    "maxValue": 100.0,
    "minValue": 90.0,
    "productDate": "2025-03-10",
    "productFinishId": 1001,
    "productFinishNo": "PF001",
    "productJobId": 2001,
    "productJobName": "作业1",
    "productLineId": 3001,
    "productLineName": "生产线1",
    "productPlanId": 4001,
    "productPlanNo": "计划1",
    "productQuantity": 100.0,
    "productScheduleId": 5001,
    "qualifiedRate": 95.0,
    "remark": "合格率很高",
    "searchValue": "",
    "serialNo": "SN001",
    "updateBy": "admin",
    "updateTime": "2025-03-11 02:05:00",
    "params": "{\"key\": \"value\"}"
  }
}
```
PUT http://localhost:8000/mesCheck/productCheck
Content-Type: application/json

{
"id": 1,
"checkDate": "",
"checkItemName": "ABC",
"checkQuantity": 0,
"checkResult": "UNQUALIFIED",
"checkStandardId": 0,
"checkUser": "",
"checkValue": 0,
"createBy": "",
"materialBatchNo": "",
"materialCode": "",
"materialId": 0,
"materialModel": "",
"materialName": "",
"materialSpecification": "",
"materialUnit": "",
"maxValue": 0,
"minValue": 0,
"productDate": "",
"productFinishId": 0,
"productFinishNo": "",
"productJobId": 0,
"productJobName": "",
"productLineId": 0,
"productLineName": "",
"productPlanId": 0,
"productPlanNo": "",
"productQuantity": 0,
"productScheduleId": 0,
"qualifiedRate": 0,
"remark": "",
"searchValue": "",
"serialNo": "",
"updateBy": "",
"updateTime": "",
"params": ""
}

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```


DELETE http://localhost:8000/mesCheck/productCheck/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": null
}
```


## bid/bidding/newsInformation

GET http://localhost:8000/bid/bidding/newsInformation/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 5,
      "title": "无人驾驶技术取得突破性进展",
      "publisher": "自动驾驶技术联盟",
      "publishDate": "2023-10-04",
      "viewCount": 510,
      "content": "最新自动驾驶算法显著提升了车辆识别能力和行驶安全性。"
    },
    {
      "id": 4,
      "title": "国际油价持续波动对经济的影响",
      "publisher": "经济观察报",
      "publishDate": "2023-10-01",
      "viewCount": 430,
      "content": "全球油价走势受到地缘政治和市场需求变化的影响。"
    },
    {
      "id": 3,
      "title": "新能源汽车市场迎来政策红利",
      "publisher": "国家发改委",
      "publishDate": "2023-09-27",
      "viewCount": 480,
      "content": "政府出台新政策支持新能源车产业，促进绿色出行。"
    }
  ]
}
```


GET http://localhost:8000/bid/bidding/newsInformation/1

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "title": "5G 技术加速产业变革",
    "publisher": "中国通信协会",
    "publishDate": "2023-09-21",
    "viewCount": 601,
    "content": "5G 商用化的推进正推动多个行业数字化升级。"
  }
}
```


## mesProduct/productFinish

GET http://localhost:8000/mesProduct/productFinish/list

```json
{
  "code": "200",
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "batchNo": "PB20250312001",
      "createBy": "admin",
      "finishDate": "2025-03-12 08:00:00",
      "finishQuantity": 100,
      "jobId": 1,
      "jobName": "Job1",
      "materialCode": "M12345",
      "materialId": 1,
      "materialModel": "ModelA",
      "materialName": "MaterialA",
      "materialSpecification": "SpecA",
      "materialUnit": "UnitA",
      "planId": 1,
      "planName": "Plan1",
      "planNo": "P001",
      "remark": "This is a remark for unfinished item",
      "scheduleId": "1",
      "serialNo": "SN20250312001",
      "status": "未入库",
      "updateBy": "admin",
      "updateTime": "2025-03-12 08:05:00"
    },
    {
      "id": 2,
      "batchNo": "PB20250312002",
      "createBy": "admin",
      "finishDate": "2025-03-12 09:00:00",
      "finishQuantity": 150,
      "jobId": 2,
      "jobName": "Job2",
      "materialCode": "M54321",
      "materialId": 2,
      "materialModel": "ModelB",
      "materialName": "MaterialB",
      "materialSpecification": "SpecB",
      "materialUnit": "UnitB",
      "planId": 2,
      "planName": "Plan2",
      "planNo": "P002",
      "remark": "This is a remark for item in storage process",
      "scheduleId": "2",
      "serialNo": "SN20250312002",
      "status": "入库中",
      "updateBy": "admin",
      "updateTime": "2025-03-12 09:05:00"
    },
    {
      "id": 3,
      "batchNo": "PB20250312003",
      "createBy": "admin",
      "finishDate": "2025-03-12 10:00:00",
      "finishQuantity": 200,
      "jobId": 3,
      "jobName": "Job3",
      "materialCode": "M67890",
      "materialId": 3,
      "materialModel": "ModelC",
      "materialName": "MaterialC",
      "materialSpecification": "SpecC",
      "materialUnit": "UnitC",
      "planId": 3,
      "planName": "Plan3",
      "planNo": "P003",
      "remark": "This is a remark for finished storage",
      "scheduleId": "3",
      "serialNo": "SN20250312003",
      "status": "已入库",
      "updateBy": "admin",
      "updateTime": "2025-03-12 10:05:00"
    }
  ]
}
```


GET http://localhost:8000/mesProduct/productFinish/1
```json
{
  "code": "200",
  "msg": "操作成功",
  "data": {
    "id": 1,
    "batchNo": "PB20250312001",
    "createBy": "admin",
    "finishDate": "2025-03-12 08:00:00",
    "finishQuantity": 100,
    "jobId": 1,
    "jobName": "Job1",
    "materialCode": "M12345",
    "materialId": 1,
    "materialModel": "ModelA",
    "materialName": "MaterialA",
    "materialSpecification": "SpecA",
    "materialUnit": "UnitA",
    "planId": 1,
    "planName": "Plan1",
    "planNo": "P001",
    "remark": "This is a remark for unfinished item",
    "scheduleId": "1",
    "serialNo": "SN20250312001",
    "status": "未入库",
    "updateBy": "admin",
    "updateTime": "2025-03-12 08:05:00"
  }
}
```


















