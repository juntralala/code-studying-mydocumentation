/** Node Type
 * Saat kita menyeleksi Node menjadi NodeLiist, kadang kita ingin tahu tipe Node tersebut
 * Apakah Element, TextElement atau yang lainnya
 * Node sendiri memiliki property bernama nodeType, dimana kita bisa melihat tipe dari node tersebut
 * https://developer.mozilla.org/en-US/docs/Web/API/Node/nodeType 
 */

/**
    +===================================+=======+=======================================================+
    | constant                          | Value | Description                                           |
    +-----------------------------------+-------+-------------------------------------------------------+
    | Node.ELEMENT_NODE                 | 1     | An Element node like <p> or <div>                     |
    | Node.ATTRIBUTE_NODE               | 2     | An Attribute of an Element                            |
    | Node.TEXT_NODE                    | 3     | The actual Text  inside an element or Attr            |
    | Node.CDATA_SECTION_NODE           | 4     | A CDATASection, such as <!CDATA[[...]]>               |
    | Node.PROCECING_INSTRUCTION_NODE   | 7     | A ProcessingInstruction of an XML document, such as   |
    |                                   |       |  <?xml-stylesheet ... ?>                              |
    | Node.COMMENT_NODE                 | 8     | A Comment node, such as <!--- ... --->                |
    | Node.DOCUMENT_NODE                | 9     | A Document node                                       |
    | Node.DOCUMENT_TYPE_NODE           | 10    | A DocumentType node, such as <!DOCTYPE html>          |
    | Node.DOCUMENT_FRAGEMENT_NODE      | 11    | A DocumentFragment node                               |
    +===================================+=======+=======================================================+
 */