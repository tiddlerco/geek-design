package com.monday.factory.factorymethod;

import com.monday.factory.simplefactory.IRuleConfigParser;
import com.monday.factory.simplefactory.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }

}