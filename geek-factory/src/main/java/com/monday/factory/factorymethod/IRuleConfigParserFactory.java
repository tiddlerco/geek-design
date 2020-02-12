package com.monday.factory.factorymethod;

import com.monday.factory.simplefactory.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}