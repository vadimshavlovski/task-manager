package com.taskmanager.common.file;

import org.apache.commons.codec.binary.Base64;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Base64Mapper {

    static String encode(final byte[] data) {
        return Base64.encodeBase64String(data);
    }

    static byte[] decode(final String base64String) {
        return Base64.decodeBase64(base64String);
    }
}
