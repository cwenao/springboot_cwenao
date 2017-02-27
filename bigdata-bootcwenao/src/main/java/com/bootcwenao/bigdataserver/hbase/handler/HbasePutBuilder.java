/**
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.bootcwenao.bigdataserver.hbase.handler;

import org.apache.hadoop.hbase.client.Put;

import java.nio.ByteBuffer;

/**
 * @author cwenao
 * @version $Id HbasePutBuilder.java, v 0.1 2017-02-24 9:31 cwenao Exp $$
 */
public class HbasePutBuilder extends Put{
    /**
     * Create a Put operation for the specified row.
     *
     * @param row row key
     */
    public HbasePutBuilder(byte[] row) {
        super(row);
    }

    /**
     * Create a Put operation for the specified row, using a given timestamp.
     *
     * @param row row key; we make a copy of what we are passed to keep local.
     * @param ts  timestamp
     */
    public HbasePutBuilder(byte[] row, long ts) {
        super(row, ts);
    }

    /**
     * We make a copy of the passed in row key to keep local.
     *
     * @param rowArray
     * @param rowOffset
     * @param rowLength
     */
    public HbasePutBuilder(byte[] rowArray, int rowOffset, int rowLength) {
        super(rowArray, rowOffset, rowLength);
    }

    /**
     * @param row row key; we make a copy of what we are passed to keep local.
     * @param ts  timestamp
     */
    public HbasePutBuilder(ByteBuffer row, long ts) {
        super(row, ts);
    }

    /**
     * @param row row key; we make a copy of what we are passed to keep local.
     */
    public HbasePutBuilder(ByteBuffer row) {
        super(row);
    }

    /**
     * We make a copy of the passed in row key to keep local.
     *
     * @param rowArray
     * @param rowOffset
     * @param rowLength
     * @param ts
     */
    public HbasePutBuilder(byte[] rowArray, int rowOffset, int rowLength, long ts) {
        super(rowArray, rowOffset, rowLength, ts);
    }

    /**
     * Copy constructor.  Creates a Put operation cloned from the specified Put.
     *
     * @param putToCopy put to copy
     */
    public HbasePutBuilder(Put putToCopy) {
        super(putToCopy);
    }
}

