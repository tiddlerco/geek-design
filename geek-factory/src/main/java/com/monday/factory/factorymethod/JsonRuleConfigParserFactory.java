package com.monday.factory.factorymethod;

import com.monday.factory.simplefactory.IRuleConfigParser;
import com.monday.factory.simplefactory.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }

}