package com.teachmeskills.lesson_8.fabric;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.document_parser.impl.DocxDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.TxtDocumentParser;

public class ParserFabric {

    public static IParser createParser(String fileName) { // вставили статик
        return switch (fileName.toLowerCase()) {
            case ".docx" -> new DocxDocumentParser();
            case ".pdf" -> new PdfDocumentParser();
            case ".txt" -> new TxtDocumentParser();
            default -> throw new IllegalArgumentException("Unsupported file format: " + fileName);
        };
        // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись
    }
}