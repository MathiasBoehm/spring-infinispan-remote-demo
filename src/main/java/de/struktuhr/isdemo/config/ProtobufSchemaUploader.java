package de.struktuhr.isdemo.config;

import de.struktuhr.isdemo.model.CustomersSchemaBuilderImpl;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.springframework.stereotype.Component;

@Component
public class ProtobufSchemaUploader {

    public ProtobufSchemaUploader(RemoteCacheManager cacheManager) {
        RemoteCache<String, String> metadataCache =
                cacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
        GeneratedSchema schema = new CustomersSchemaBuilderImpl();
        metadataCache.put(schema.getProtoFileName(), schema.getProtoFile());
    }

}