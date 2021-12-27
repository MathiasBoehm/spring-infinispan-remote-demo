package de.struktuhr.isdemo.model;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(schemaPackageName = "demo",
        includeClasses = {Customer.class, City.class})
public interface CustomersSchemaBuilder extends GeneratedSchema {

}


