package com.luck.lizzie.batis.builder.xml;

import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.builder.BaseBuilder;
import com.luck.lizzie.batis.io.Resources;
import com.luck.lizzie.batis.mapping.MappedStatement;
import com.luck.lizzie.batis.session.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;


/**
 * @Author liukun.inspire
 * @Date 2024/1/3 10:13
 * @PackageName: com.luck.lizzie.batis.builder.xml
 * @ClassName: XMLConfigBuilder
 * @Version 1.0
 */
@Slf4j
public class XMLConfigBuilder extends BaseBuilder {

    public XMLConfigBuilder(Configuration configuration) {
        super(configuration);
    }

    public Configuration parse(Reader reader) throws ClassNotFoundException, DocumentException {

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new InputSource(reader));
        Element rootElement = read.getRootElement();

        Element mappers = rootElement.element("mappers");
        for (Element mapperElement : mappers.elements()) {
            // mapper Node
            String resource = mapperElement.attribute("resource").getValue();
            InputStreamReader inputStreamReader = Resources.loadResourceReader(resource);
            SAXReader saxReader1 = new SAXReader();
            Document mapperDocument = saxReader1.read(new InputSource(inputStreamReader));

            Element mapperRootElement = mapperDocument.getRootElement();
            parseMappedStatement(mapperRootElement);
            // configuration.addMappedStatement(mappedStatement);
            // configuration.addMapper(Class.forName(namespace.getName()));
        }
        return configuration;

    }

    private void parseMappedStatement(Element element) throws ClassNotFoundException {
        // 也有可能有很多个sql呀
        for (Element sqlElement : element.elements()) {
            String id = sqlElement.attributeValue("id");
            String parameterType = sqlElement.attributeValue("parameterType");
            String resultType = sqlElement.attributeValue("resultType");
            String sqlContent = sqlElement.getStringValue();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setParameterType(Class.forName(parameterType));
            mappedStatement.setResultType(Class.forName(resultType));
            mappedStatement.setSql(sqlContent);
            String namespace = element.attributeValue("namespace");
            String msId = namespace + "." + id;
            Class<?> mapperClass = Class.forName(namespace);
            mappedStatement.setMapperClass(mapperClass);
            mappedStatement.setKey(msId);
            System.out.println(mappedStatement);
            configuration.addMappedStatement(mappedStatement);
            configuration.addMapper(mapperClass);
        }

    }

}
