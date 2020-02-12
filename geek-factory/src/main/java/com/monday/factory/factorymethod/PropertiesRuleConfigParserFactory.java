package com.monday.factory.factorymethod;

import com.monday.factory.simplefactory.IRuleConfigParser;
import com.monday.factory.simplefactory.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }

}