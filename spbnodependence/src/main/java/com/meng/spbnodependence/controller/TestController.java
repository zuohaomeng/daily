package com.meng.spbnodependence.controller;

import com.alibaba.fastjson.JSON;
import com.meng.spbnodependence.bean.OfflineStoreResult;

import java.util.*;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-04 17:22
 */
public class TestController {


    public static void main(String[] args) {
        String t = "[{\"address\":\"深圳市南山区天利中央商务广场大厦A栋10层1004、1005部分单元\",\"areaCode\":10101201,\"businessHours\":\"10:30~21:00\",\"city\":\"深圳\",\"latitude\":\"22.5245\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1380683173307200.jpg\",\"longitude\":\"113.940569\",\"storeId\":89,\"storeName\":\"海岸城店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1382863277906700.jpg\"},{\"address\":\"深圳市福田区滨河大道9289号滨河时代裙楼京基百纳时代二楼217号商铺\",\"areaCode\":10101201,\"businessHours\":\"10:30~21:00\",\"city\":\"深圳\",\"latitude\":\"22.53393\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1209291409967900.jpg\",\"longitude\":\"114.033151\",\"storeId\":88,\"storeName\":\"KKONE店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1209290750993200.jpg\"},{\"address\":\"深圳市宝安区新湖路壹方中心B座25层01/02/03/04/05，10号单元\",\"areaCode\":10101201,\"businessHours\":\"10:30~21:00\",\"city\":\"深圳\",\"latitude\":\"22.558371612644529\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1526383603095.jpg\",\"longitude\":\"113.89410412695874\",\"storeId\":78,\"storeName\":\"壹方店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593226397100.jpg\"},{\"address\":\"广州市天河区珠江新城花城大道18号建滔广场15楼1501珍爱网\",\"areaCode\":10101002,\"businessHours\":\"10:30~21:00\",\"city\":\"广州\",\"latitude\":\"23.124951\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/960080196827100.jpg\",\"longitude\":\"113.323752\",\"storeId\":72,\"storeName\":\"花城店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/960079453516900.jpg\"},{\"address\":\"上海市黄浦区西藏中路268号来福士49层2、3、4单元\",\"areaCode\":10103000,\"businessHours\":\"10:30~21:00\",\"city\":\"上海\",\"latitude\":\"31.23823255746703\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1507535412553.jpg\",\"longitude\":\"121.48312894445343\",\"storeId\":60,\"storeName\":\"来福士店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179587944099500.jpg\"},{\"address\":\"北京市东城区东直门天恒大厦22层2201-2205\",\"areaCode\":10102000,\"businessHours\":\"10:30~21:00\",\"city\":\"北京\",\"latitude\":\"39.94624075522277\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/bj2.jpg\",\"longitude\":\"116.44344325603039\",\"storeId\":30,\"storeName\":\"东直门店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588601989800.jpg\"},{\"address\":\"深圳市罗湖区地王大厦53层5312-5316\",\"areaCode\":10101201,\"businessHours\":\"10:30~21:00\",\"city\":\"深圳\",\"latitude\":\"22.548817242126984\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/sz2.jpg\",\"longitude\":\"114.11632093248319\",\"storeId\":17,\"storeName\":\"地王店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593056635500.jpg\"},{\"address\":\"上海市浦东新区浦东南路1118号鄂尔多斯国际大厦1201-1205室\",\"areaCode\":10103000,\"businessHours\":\"10:30~21:00\",\"city\":\"上海\",\"latitude\":\"31.233375534904174\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/sh1.jpg\",\"longitude\":\"121.52220327852638\",\"storeId\":16,\"storeName\":\"八佰伴店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179587798305900.jpg\"},{\"address\":\"深圳市南山区科发路19号华润置地大厦D座第25层6-10单元\",\"areaCode\":10101201,\"businessHours\":\"10:30~21:00\",\"city\":\"深圳\",\"latitude\":\"22.547450164161967\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1540898257703.jpg\",\"longitude\":\"113.95946791703105\",\"storeId\":7,\"storeName\":\"万象店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179592897131100.jpg\"},{\"address\":\"广州市天河区体育东路114号财富广场西座2401单元（即24楼整层）\",\"areaCode\":10101002,\"businessHours\":\"10:30~21:00\",\"city\":\"广州\",\"latitude\":\"23.141887188961534\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/gz0.jpg\",\"longitude\":\"113.33522397124645\",\"storeId\":4,\"storeName\":\"财富店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179590991052700.jpg\"},{\"address\":\"上海市徐汇区零陵路899号飞洲国际大厦30层A、C、D、E、F、G室\",\"areaCode\":10103000,\"businessHours\":\"10:30~21:00\",\"city\":\"上海\",\"latitude\":\"31.189626879567343\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/sh0.jpg\",\"longitude\":\"121.44402570560409\",\"storeId\":3,\"storeName\":\"体育馆店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179587636182400.jpg\"},{\"address\":\"北京市西城区西直门外大街1号院3号楼西环广场T1座写字楼21层 D1-D5、D12-D15单位\",\"areaCode\":10102000,\"businessHours\":\"10:30~21:00\",\"city\":\"北京\",\"latitude\":\"39.946317437048637\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/bj1.jpg\",\"longitude\":\"116.35906001886545\",\"storeId\":2,\"storeName\":\"西直门店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588951524300.jpg\"},{\"address\":\"北京市朝阳区东三环中路乙10号艾维克大厦第20层第01-08号\",\"areaCode\":10102000,\"businessHours\":\"10:30~21:00\",\"city\":\"北京\",\"latitude\":\"39.910787043309507\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/bj0.jpg\",\"longitude\":\"116.46923239720434\",\"storeId\":1,\"storeName\":\"国贸店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588788657400.jpg\"},{\"address\":\"厦门市思明区鹭江道8号国际银行大厦29楼H单元\",\"areaCode\":10107002,\"businessHours\":\"10:30~21:00\",\"city\":\"厦门\",\"latitude\":\"24.458791693651294\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/xm1.jpg\",\"longitude\":\"118.08220898510459\",\"storeId\":11,\"storeName\":\"中山路店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/3103407779294900.jpg\"},{\"address\":\"成都市武侯区人民南路四段3号来福士广场塔一27层\",\"areaCode\":10127001,\"businessHours\":\"10:30~21:00\",\"city\":\"成都\",\"latitude\":\"30.63775234136912\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/cd1.jpg\",\"longitude\":\"104.07455873766533\",\"storeId\":12,\"storeName\":\"来福士店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179591474061200.jpg\"},{\"address\":\"长沙市天心区湘江中路二段36号华远华中心5号楼(华远国际中心)22层2201-2204号\",\"areaCode\":10116001,\"businessHours\":\"10:30~21:00\",\"city\":\"长沙\",\"latitude\":\"28.19556913389398\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1493713615266.jpg\",\"longitude\":\"112.97629253027067\",\"storeId\":14,\"storeName\":\"五一广场店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179595567487700.jpg\"},{\"address\":\"合肥市政务文化新区潜山路与习友路交叉口华润大厦B座1708、1709单元\",\"areaCode\":10106001,\"businessHours\":\"10:30~21:00\",\"city\":\"合肥\",\"latitude\":\"31.80629353570291\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/181577665673100.jpg\",\"longitude\":\"117.23598091702562\",\"storeId\":15,\"storeName\":\"华润店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/181578424159600.jpg\"},{\"address\":\"大连市中山区中山路88号天安国际大厦4001珍爱网\",\"areaCode\":10120006,\"businessHours\":\"10:30~21:00\",\"city\":\"大连\",\"latitude\":\"38.924538\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/dl_dlzs.jpg\",\"longitude\":\"121.643055\",\"storeId\":18,\"storeName\":\"中山店\",\"storePicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/qt_dlzs.jpg\"},{\"address\":\"广东省东莞市南城区元美西路8号华凯广场A座301/02/03/05/06室\",\"areaCode\":10101007,\"businessHours\":\"10:30~21:00\",\"city\":\"东莞\",\"latitude\":\"23.0191485987967\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/dg0.jpg\",\"longitude\":\"113.75233953503384\",\"storeId\":19,\"storeName\":\"元美店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588091115000.jpg\"},{\"address\":\"佛山市禅城区祖庙路29号岭南天地商务大厦15层1501-1510、1514室\",\"areaCode\":10101003,\"businessHours\":\"10:30~21:00\",\"city\":\"佛山\",\"latitude\":\"23.0331650685889\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1526382509207.jpg\",\"longitude\":\"113.11930787068553\",\"storeId\":20,\"storeName\":\"祖庙店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588446407100.jpg\"},{\"address\":\"济南市历下区世茂国际广场商务办公B座701、713-717室\",\"areaCode\":10124003,\"businessHours\":\"10:30~21:00\",\"city\":\"济南\",\"latitude\":\"36.67136101546344\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/jn0.jpg\",\"longitude\":\"117.03634384955703\",\"storeId\":21,\"storeName\":\"世茂店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179592738077600.jpg\"},{\"address\":\"昆明市盘龙区北京路延长线世纪俊园二期1幢俊发中心办公室8层8A号\",\"areaCode\":10130001,\"businessHours\":\"10:30~21:00\",\"city\":\"昆明\",\"latitude\":\"25.06810880076995\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1529900228060.jpg\",\"longitude\":\"102.7300303282147\",\"storeId\":22,\"storeName\":\"俊发店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179591812053800.jpg\"},{\"address\":\"南宁市青秀区中新路9号广西九洲国际第29层2901B、2901C、2902、2903号房\",\"areaCode\":10109001,\"businessHours\":\"10:30~21:00\",\"city\":\"南宁\",\"latitude\":\"22.81662147678036\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1531880138620.jpg\",\"longitude\":\"108.4018225396294\",\"storeId\":23,\"storeName\":\"九洲店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179589333099100.jpg\"},{\"address\":\"浙江省宁波市江北区大庆南路102号绿地中心1号楼,15楼03单元\",\"areaCode\":10131003,\"businessHours\":\"10:30~21:00\",\"city\":\"宁波\",\"latitude\":\"29.888243\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/dl_nbwt.jpg\",\"longitude\":\"121.565331\",\"storeId\":24,\"storeName\":\"外滩店\",\"storePicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/qt_nbwt.jpg\"},{\"address\":\"青岛市市南区香港中路40号新世界数码港旗舰大厦5楼\",\"areaCode\":10124001,\"businessHours\":\"10:30~21:00\",\"city\":\"青岛\",\"latitude\":\"36.07139110471504\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/qd0.jpg\",\"longitude\":\"120.39687680711708\",\"storeId\":25,\"storeName\":\"香港中路店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179595719100700.jpg\"},{\"address\":\"沈阳市和平区青年大街286号华润大厦第37层05、06、07单元\",\"areaCode\":10120001,\"businessHours\":\"10:30~21:00\",\"city\":\"沈阳\",\"latitude\":\"41.783704919988249\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1529547919394.jpg\",\"longitude\":\"123.43954761812552\",\"storeId\":26,\"storeName\":\"华润店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179592452059300.jpg\"},{\"address\":\"温州市鹿城区车站大道577号财富中心908室\",\"areaCode\":10131002,\"businessHours\":\"10:30~21:00\",\"city\":\"温州\",\"latitude\":\"28.00442020352172\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/wz0.jpg\",\"longitude\":\"120.6892568516336\",\"storeId\":27,\"storeName\":\"财富店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593376036400.jpg\"},{\"address\":\"无锡市崇安区人民中路139号无锡恒隆广场办公楼1座4007-4009单元\",\"areaCode\":10118003,\"businessHours\":\"10:30~21:00\",\"city\":\"无锡\",\"latitude\":\"31.58078898632095\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/wx0.jpg\",\"longitude\":\"120.30400262188189\",\"storeId\":28,\"storeName\":\"恒隆店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179591642185000.jpg\"},{\"address\":\"郑州市二七区民主路10号华润大厦21F4-5单元\",\"areaCode\":10113001,\"businessHours\":\"10:30~21:00\",\"city\":\"郑州\",\"latitude\":\"34.76176762991625\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1523357946433.jpg\",\"longitude\":\"113.6666730885019\",\"storeId\":29,\"storeName\":\"华润店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179594760034400.jpg\"},{\"address\":\"武汉市武昌区中北路汉街总部国际D座17层01-04、10单元\",\"areaCode\":10115001,\"businessHours\":\"10:30~21:00\",\"city\":\"武汉\",\"latitude\":\"30.558646813179306\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/wh1.jpg\",\"longitude\":\"114.35284884748742\",\"storeId\":31,\"storeName\":\"汉街店\",\"storePicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/whhj2020.jpg\"},{\"address\":\"天津市河西区南京路39号天津国际贸易中心第30层01-08单元\",\"areaCode\":10104000,\"businessHours\":\"10:30~21:00\",\"city\":\"天津\",\"latitude\":\"39.11967536426204\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/tj0.jpg\",\"longitude\":\"117.22340234938655\",\"storeId\":32,\"storeName\":\"小白楼店\",\"storePicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/tkxbl2020.jpg\"},{\"address\":\"福州市鼓楼区五四路3号三盛国际大厦36楼\",\"areaCode\":10107001,\"businessHours\":\"10:30~21:00\",\"city\":\"福州\",\"latitude\":\"26.093350830392219\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1502366565895.jpg\",\"longitude\":\"119.31477213880172\",\"storeId\":33,\"storeName\":\"五四路店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593998071200.jpg\"},{\"address\":\"杭州市江干区财富金融中心2幢3903、3904、3905室\",\"areaCode\":10131001,\"businessHours\":\"10:30~21:00\",\"city\":\"杭州\",\"latitude\":\"30.247763229458223\",\"listPicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/shop_pic/hz1.jpg\",\"longitude\":\"120.21659273474185\",\"storeId\":37,\"storeName\":\"钱江店\",\"storePicURL\":\"http://images.zastatic.com/zhenai3/zhenai2012/img/offline/hzqj2020.jpg\"},{\"address\":\"贵州省贵阳市南明区花果园E9号（国际金融街3号）1单元1604号\",\"areaCode\":10110001,\"businessHours\":\"10:30~21:00\",\"city\":\"贵阳\",\"latitude\":\"26.576069131715138\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476863076354.jpg\",\"longitude\":\"106.69523849920938\",\"storeId\":42,\"storeName\":\"花果园店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179594598040400.jpg\"},{\"address\":\"惠州市江北文昌一路11号铂金府华贸大厦3号楼1单元19层02-05号\",\"areaCode\":10101008,\"businessHours\":\"10:30~21:00\",\"city\":\"惠州\",\"latitude\":\"23.108616628845714\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476865300917.jpg\",\"longitude\":\"114.42183417729167\",\"storeId\":44,\"storeName\":\"华贸店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179591159169800.jpg\"},{\"address\":\"金华市八一北街118号汇金国际商务中心2301、2307-2309室\",\"areaCode\":10131009,\"businessHours\":\"10:30~21:00\",\"city\":\"金华\",\"latitude\":\"29.107149134957746\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476866871191.jpg\",\"longitude\":\"119.65548149293737\",\"storeId\":45,\"storeName\":\"汇金店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179595243295300.jpg\"},{\"address\":\"南昌市红谷滩新区红谷中大道1669号华尔登商业中心喜来登酒店、办公楼写字楼905室\",\"areaCode\":10119001,\"businessHours\":\"10:30~21:00\",\"city\":\"南昌\",\"latitude\":\"28.697223020173519\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476867588369.jpg\",\"longitude\":\"115.87429020219362\",\"storeId\":46,\"storeName\":\"红谷滩店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1476867593299.jpg\"},{\"address\":\"泉州市丰泽区宝洲路中段南侧泉州浦西万达广场1号写字楼1B塔B3402、B3403、B3407单元\",\"areaCode\":10107003,\"businessHours\":\"10:30~21:00\",\"city\":\"泉州\",\"latitude\":\"24.887261167836848\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476867762803.jpg\",\"longitude\":\"118.60682439823536\",\"storeId\":47,\"storeName\":\"万达店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179592602312200.jpg\"},{\"address\":\"石家庄市中山东路39号勒泰中心A座2810~2813、2818、2819单元\",\"areaCode\":10112001,\"businessHours\":\"10:30~21:00\",\"city\":\"石家庄\",\"latitude\":\"38.049679054954818\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476868216610.jpg\",\"longitude\":\"114.51325436574084\",\"storeId\":48,\"storeName\":\"勒泰店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593830173000.jpg\"},{\"address\":\"太原市亲贤北街79号茂业中心3203、3204室\",\"areaCode\":10125001,\"businessHours\":\"10:30~21:00\",\"city\":\"太原\",\"latitude\":\"37.831216\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/2082177453235900.jpg\",\"longitude\":\"112.574417\",\"storeId\":49,\"storeName\":\"茂业店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/2082176635763800.jpg\"},{\"address\":\"中山市东区中山三路16号之三国际金融中心47层 6、7、8、9、10卡\",\"areaCode\":10101011,\"businessHours\":\"10:30~21:00\",\"city\":\"中山\",\"latitude\":\"22.518255699688458\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476868754090.jpg\",\"longitude\":\"113.38965535631677\",\"storeId\":50,\"storeName\":\"利和店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179588285215700.jpg\"},{\"address\":\"广东省珠海市香洲区九州大道西富华里中海大厦B座2103、2104\",\"areaCode\":10101005,\"businessHours\":\"10:30~21:00\",\"city\":\"珠海\",\"latitude\":\"22.240886615311696\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1476868964940.jpg\",\"longitude\":\"113.548408629278\",\"storeId\":51,\"storeName\":\"富华里店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179593673241000.jpg\"},{\"address\":\"南京市中山南路1号南京中心17楼,AB区\",\"areaCode\":10118001,\"businessHours\":\"10:30~21:00\",\"city\":\"南京\",\"latitude\":\"32.047070380982137\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1494396643526.jpg\",\"longitude\":\"118.7918911660237\",\"storeId\":52,\"storeName\":\"新街口店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179589148058900.jpg\"},{\"address\":\"成都市锦江区春熙路国际金融中心2号楼22楼\",\"areaCode\":10127001,\"businessHours\":\"10:30~21:00\",\"city\":\"成都\",\"latitude\":\"30.66232002888318\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1494401929446.jpg\",\"longitude\":\"104.0841589816505\",\"storeId\":53,\"storeName\":\"春熙路店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179591313264600.jpg\"},{\"address\":\"重庆市渝中区民族路188号WFC51层4-2、5、6单元\",\"areaCode\":10105000,\"businessHours\":\"10:30~21:00\",\"city\":\"重庆\",\"latitude\":\"29.564876252032428\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1504258857548.jpg\",\"longitude\":\"106.58420422192289\",\"storeId\":59,\"storeName\":\"解放碑店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179595108119700.jpg\"},{\"address\":\"陕西省西安市经济技术开发区未央路170号赛高城市广场2号楼-企业总部大厦26层1、2、8单元\",\"areaCode\":10126001,\"businessHours\":\"10:30~21:00\",\"city\":\"西安\",\"latitude\":\"34.34411520173194\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1517976298377.jpg\",\"longitude\":\"108.95010521506751\",\"storeId\":66,\"storeName\":\"赛高店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179594310134300.jpg\"},{\"address\":\"重庆市江北区江北嘴庆云路1号国金中心T1办公楼40F 8-10单元\",\"areaCode\":10105000,\"businessHours\":\"10:30~21:00\",\"city\":\"重庆\",\"latitude\":\"29.583159451076037\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1517976753483.jpg\",\"longitude\":\"106.57972687143203\",\"storeId\":70,\"storeName\":\"国金店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179594905440500.jpg\"},{\"address\":\"苏州市工业园区苏州大道西119号苏悦中心13F6-8（有分割）单元\",\"areaCode\":10118002,\"businessHours\":\"10:30~21:00\",\"city\":\"苏州\",\"latitude\":\"31.320519679689139\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/1521539765472.jpg\",\"longitude\":\"120.6761049464991\",\"storeId\":74,\"storeName\":\"星海店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179594155322500.jpg\"},{\"address\":\"江苏省常州市钟楼区延陵西路123号吾悦国际大厦20层01、02单元\",\"areaCode\":10118238,\"businessHours\":\"10:30~21:00\",\"city\":\"常州\",\"latitude\":\"31.7867197919\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/58289477473581.jpg\",\"longitude\":\"119.9547238788\",\"storeId\":81,\"storeName\":\"吾悦店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179590661342800.jpg\"},{\"address\":\"吉林省长春市南关区重庆路88号活力城国际中心19层01、05单元\",\"areaCode\":10117050,\"businessHours\":\"10:30~21:00\",\"city\":\"长春\",\"latitude\":\"43.8972558626\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/58486543442590.jpg\",\"longitude\":\"125.3404700426\",\"storeId\":83,\"storeName\":\"活力城店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179595402016400.jpg\"},{\"address\":\"哈尔滨市南岗区红军街15号奥威斯发展大厦28层\",\"areaCode\":10114083,\"businessHours\":\"10:30~21:00\",\"city\":\"哈尔滨\",\"latitude\":\"45.6072017342\",\"listPicURL\":\"http://photo.zastatic.com/photo/activity/58377320889322.jpg\",\"longitude\":\"126.6178819550\",\"storeId\":85,\"storeName\":\"奥威斯店\",\"storePicURL\":\"http://photo.zastatic.com/photo/activity/1179589810436600.jpg\"}]";

        List<OfflineStoreResult> offlineStoreResults = JSON.parseArray(t, OfflineStoreResult.class);
        offlineStoreResults.stream().sorted(Comparator.comparing(OfflineStoreResult::getStoreId)).forEach(e->{
           if(e.getStoreId()==49){
               System.out.println(e);
           }
        });


//        offlineStoreResults.stream()
//                .peek(e -> e.setListPicURL(e.getListPicURL().substring(0, e.getListPicURL().lastIndexOf("/"))))
//                .map(OfflineStoreResult::getListPicURL)
//                .collect(Collectors.toList()).stream().distinct().forEach(System.out::println);

//        collect.stream().peek(

        System.out.println(1);

    }
}

