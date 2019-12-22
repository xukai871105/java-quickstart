package com.example.common;

import com.google.common.primitives.Bytes;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * List类型转化为Byte数组类型
 * @author xukai
 */
public class ListByte2ByteArrayTest {
    @Test
    public void test01() {
        List<Byte> list = new ArrayList<>();
        list.add((byte)0x01);
        list.add((byte)0x02);
        list.add((byte)0x03);
        // guava
        byte[] byteArray = Bytes.toArray(list);

        System.out.println(Hex.encodeHexString(byteArray));
    }

}
