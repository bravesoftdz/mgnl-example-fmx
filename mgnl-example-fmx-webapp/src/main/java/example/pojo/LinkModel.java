package example.pojo;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.kasisoft.mgnl.jcx.IContent;
import com.kasisoft.mgnl.jcx.IPostProcessor;

import info.magnolia.repository.RepositoryConstants;
import info.magnolia.templating.functions.TemplatingFunctions;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class LinkModel implements IPostProcessor, IContent {

  @XmlAttribute
  private String                      link;
  
  @XmlTransient 
  private String                      target;
  
  @XmlTransient
  private TemplatingFunctions         cmsFn;
  
  @Inject
  public LinkModel( TemplatingFunctions templatingFunctions ) {
    cmsFn = templatingFunctions;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getTarget() {
    return target;
  }

  
  @Override
  public void postprocess() {
    if( link != null ) {
      target = cmsFn.link( RepositoryConstants.WEBSITE, link );
    }
  }
  
  @Override
  public boolean hasContent() {
    // without a link we don't consider this element to have content
    return target != null;
  }
  
} /* ENDCLASS */