package com.example.ko.mobileoffice.xmlparser;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Map;

/**
 * Created by ko on 2015-02-10.
 */
public class PositionParser extends Parser {
    private int row;
    private int col;
    public PositionParser(String xmlData)
    {
        super(xmlData);
        Element root = dom.getDocumentElement();
        NodeList responseList = root.getElementsByTagName("response");
        Element response = (Element)responseList.item(0);
        NodeList reponseBlockNode = response.getElementsByTagName("block");
        Element block = (Element)reponseBlockNode.item(0);

        this.row = Integer.parseInt(block.getAttribute("row"));
        this.col = Integer.parseInt(block.getAttribute("col"));

    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
