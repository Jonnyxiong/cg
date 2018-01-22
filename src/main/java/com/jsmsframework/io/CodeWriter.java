package com.jsmsframework.io;


import com.jsmsframework.io.config.CodeText;

public interface CodeWriter {

    void write(CodeText codeText);

    void write(String path, String fileName, String content);

}
