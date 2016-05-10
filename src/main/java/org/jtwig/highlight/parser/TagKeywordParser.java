package org.jtwig.highlight.parser;

import org.jtwig.highlight.parser.base.BasicParser;
import org.jtwig.highlight.parser.context.ParserContext;
import org.parboiled.Rule;

public class TagKeywordParser extends BasicParser {
    public TagKeywordParser(ParserContext context) {
        super(TagKeywordParser.class, context);
    }

    @Override
    public Rule parse() {
        IdentifierParser identifierParser = getParserContext().parsers().get(IdentifierParser.class);
        return Sequence(
                identifierParser.parse(),
                push(getParserContext().formatter().tagKeyword(match()))
        );
    }
}
