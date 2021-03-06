package com.pmdiss.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Author: Hunter
 * Date: 2019/3/22 14:00
 */
@Configuration
//@EnableConfigurationProperties(WxMaConfiguration.class)
public class WxMaConfiguration {
//    private final WxMaMessageHandler templateMsgHandler = (wxMessage, context, service, sessionManager) ->
//            service.getMsgService().sendTemplateMsg(WxMaTemplateMessage.builder()
//                    .templateId("此处更换为自己的模板id")
//                    .formId("自己替换可用的formid")
//                    .data(Lists.newArrayList(
//                            new WxMaTemplateData("keyword1", "339208499", "#173177")))
//                    .toUser(wxMessage.getFromUser())
//                    .build());
//
//    private final WxMaMessageHandler logHandler = (wxMessage, context, service, sessionManager) -> {
//        System.out.println("收到消息：" + wxMessage.toString());
//        service.getMsgService().sendKefuMsg(WxMaKefuMessage.newTextBuilder().content("收到信息为：" + wxMessage.toJson())
//                .toUser(wxMessage.getFromUser()).build());
//    };
//
//    private final WxMaMessageHandler textHandler = (wxMessage, context, service, sessionManager) ->
//            service.getMsgService().sendKefuMsg(WxMaKefuMessage.newTextBuilder().content("回复文本消息")
//                    .toUser(wxMessage.getFromUser()).build());
//
//    private final WxMaMessageHandler picHandler = (wxMessage, context, service, sessionManager) -> {
//        try {
//            WxMediaUploadResult uploadResult = service.getMediaService()
//                    .uploadMedia("image", "png",
//                            ClassLoader.getSystemResourceAsStream("tmp.png"));
//            service.getMsgService().sendKefuMsg(
//                    WxMaKefuMessage
//                            .newImageBuilder()
//                            .mediaId(uploadResult.getMediaId())
//                            .toUser(wxMessage.getFromUser())
//                            .build());
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }
//    };
//
//    private final WxMaMessageHandler qrcodeHandler = (wxMessage, context, service, sessionManager) -> {
//        try {
//            final File file = service.getQrcodeService().createQrcode("123", 430);
//            WxMediaUploadResult uploadResult = service.getMediaService().uploadMedia("image", file);
//            service.getMsgService().sendKefuMsg(
//                    WxMaKefuMessage
//                            .newImageBuilder()
//                            .mediaId(uploadResult.getMediaId())
//                            .toUser(wxMessage.getFromUser())
//                            .build());
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }
//    };
//
//    private WxMaProperties properties;
//
//    private static Map<String, WxMaMessageRouter> routers = Maps.newHashMap();
//    private static Map<String, WxMaService> maServices = Maps.newHashMap();
//
//    @Autowired
//    public WxMaConfiguration(WxMaProperties properties) {
//        this.properties = properties;
//    }
//
//    public static Map<String, WxMaMessageRouter> getRouters() {
//        return routers;
//    }
//
//    public static WxMaService getMaService(String appid) {
//        WxMaService wxService = maServices.get(appid);
//        if (wxService == null) {
//            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
//        }
//        return wxService;
//    }
//
//    @Bean
//    public Object services() {
//        maServices = this.properties.getConfigs()
//                .stream()
//                .map(a -> {
//                    WxMaInMemoryConfig config = new WxMaInMemoryConfig();
//                    config.setAppid(a.getAppid());
//                    config.setSecret(a.getSecret());
//                    config.setToken(a.getToken());
//                    config.setAesKey(a.getAesKey());
//                    config.setMsgDataFormat(a.getMsgDataFormat());
//
//                    WxMaService service = new WxMaServiceImpl();
//                    service.setWxMaConfig(config);
//                    routers.put(a.getAppid(), this.newRouter(service));
//                    return service;
//                }).collect(Collectors.toMap(s -> s.getWxMaConfig().getAppid(), a -> a));
//
//        return Boolean.TRUE;
//    }
//
//    private WxMaMessageRouter newRouter(WxMaService service) {
//        final WxMaMessageRouter router = new WxMaMessageRouter(service);
//        router
//                .rule().handler(logHandler).next()
//                .rule().async(false).content("模板").handler(templateMsgHandler).end()
//                .rule().async(false).content("文本").handler(textHandler).end()
//                .rule().async(false).content("图片").handler(picHandler).end()
//                .rule().async(false).content("二维码").handler(qrcodeHandler).end();
//        return router;
//    }

}