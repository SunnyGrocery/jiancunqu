package edu.sust.jiancunqu.Utils;

import com.obs.services.ObsClient;
import org.springframework.stereotype.Component;

@Component
public class ObsUtil {
    private static final String endPoint = "obs.cn-east-3.myhuaweicloud.com";

    private static final String ak = "EPLSETJPABV27GJIFUZH";

    private static final String sk = "nUuQvmkY1qeHoyPMwnexrYPPmdRcSdQZCX958sqw";


    private static final String bucketLocation = "cn-east-3";

    public ObsClient getInstance() {
        return new ObsClient(ak, sk, endPoint);
    }
}
