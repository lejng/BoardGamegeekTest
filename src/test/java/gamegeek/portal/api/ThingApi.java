package gamegeek.portal.api;

import base.BaseApi;
import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeList;
import gamegeek.portal.entities.VoteEntity;
import io.restassured.response.ResponseBodyData;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import utils.XmlParser;
import java.util.LinkedList;
import java.util.List;

public class ThingApi extends BaseApi {
    private static final String GET_THING_URL = combineUrl("xmlapi2/thing");

    public List<VoteEntity> getLanguageDependenceVoteResultForThingById(String id){
        String response = getThing(id).asString();
        return getLanguageDependenceVoteResultFromResponse(response);
    }

    private ResponseBodyData getThing(String id){
        ResponseBodyData response = getRequestSpecification().param("id", id).get(GET_THING_URL);
        return response;
    }

    private static List<VoteEntity> getLanguageDependenceVoteResultFromResponse(String xml) {
        String xpathValue = "//poll[@name='language_dependence']//result";
        List<VoteEntity> votes = new LinkedList<>();
        DTMNodeList result = XmlParser.getValueByXpath(xml, xpathValue);
        for(int index = 0; index < result.getLength(); index++){
            Node node = result.item(index);
            NamedNodeMap attributes = node.getAttributes();
            String question = attributes.getNamedItem("value").getNodeValue();
            int voteCount = Integer.parseInt(attributes.getNamedItem("numvotes").getNodeValue());
            VoteEntity vote = new VoteEntity(question, voteCount);
            votes.add(vote);
        }
        return votes;
    }
}
