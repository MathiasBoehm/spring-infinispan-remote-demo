package de.struktuhr.isdemo.model;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum City {
    @ProtoEnumValue(number = 1)
    PARIS,
    @ProtoEnumValue(number = 2)
    LONDON,
    @ProtoEnumValue(number = 3)
    NEW_YORK
}
