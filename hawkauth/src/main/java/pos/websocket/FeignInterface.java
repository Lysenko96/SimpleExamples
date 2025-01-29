//package pos.websocket;
//
//
//import feign.Headers;
//import feign.Param;
//import feign.RequestLine;
//import feign.Response;
//
//
//@Headers({
//        "accept-encoding: gzip, deflate, br",
//        "user-agent: dpos",
//        "Authorization: {paramAuth}"
//})
//
//public interface FeignInterface {
//    @RequestLine("GET /api/v1/receipts/{operationId}/status")
//    Response getByOperationId(@Param("operationId") String operationId, @Param("paramAuth") String paramAuth);
//
//}
