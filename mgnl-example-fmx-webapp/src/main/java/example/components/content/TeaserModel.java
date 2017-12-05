package example.components.content;

import java.util.Arrays;
import java.util.List;

import javax.jcr.Node;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.kasisoft.mgnl.jcx.JcxUnmarshaller;

import example.pojo.Dummy;
import example.pojo.LinkModel;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class TeaserModel<D extends ConfiguredTemplateDefinition> extends AbstractComponentModel<D> {

  @XmlElement(name = JcxUnmarshaller.NAME_DIRECT)
  private LinkModel   link;
  
  @XmlAttribute
  private String      title;
  
  @XmlAttribute
  private String      text;
  
  @XmlTransient
  private List<Dummy> list;
  
  public TeaserModel( Node content, D definition, RenderingModel<?> parent, JcxUnmarshaller jcxUnmarshaller ) {
    super( content, definition, parent, jcxUnmarshaller );
    list = Arrays.asList(
      new Dummy( "First"  ),
      new Dummy( "Second" ),
      new Dummy( "Third"  )
    );
  }
  
  public List<Dummy> getList() {
    return list;
  }
  
  public LinkModel getLink() {
    return link;
  }
  
  public void setLink(LinkModel link) {
    this.link = link;
  }
  
  public String getText() {
    return text;
  }
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
} /* ENDCLASS */
