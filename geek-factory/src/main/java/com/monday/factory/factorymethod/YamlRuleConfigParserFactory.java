package com.monday.factory.factorymethod;

import com.monday.factory.simplefactory.IRuleConfigParser;
import com.monday.factory.simplefactory.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }

}