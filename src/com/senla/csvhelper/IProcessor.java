package com.senla.csvhelper;

import java.util.List;

interface IProcessor {

    void write(Object obj) throws Exception;

    List<Object> read(Class cls) throws Exception;
}
