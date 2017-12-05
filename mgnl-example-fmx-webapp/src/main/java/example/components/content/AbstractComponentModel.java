package example.components.content;

import java.util.function.BiFunction;

import javax.jcr.Node;
import javax.xml.bind.annotation.XmlTransient;

import com.kasisoft.mgnl.jcx.JcxUnmarshaller;

import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public abstract class AbstractComponentModel<D extends ConfiguredTemplateDefinition> extends RenderingModelImpl<D> {

  @XmlTransient
  private JcxUnmarshaller                                                          unmarshaller;
  
  @XmlTransient
  private BiFunction<Node, AbstractComponentModel<D>, AbstractComponentModel<D>>   loader;
  
  public AbstractComponentModel( Node content, D definition, RenderingModel<?> parent, JcxUnmarshaller jcxUnmarshaller ) {
    super( content, definition, parent );
    unmarshaller  = jcxUnmarshaller;
    loader        = (BiFunction<Node, AbstractComponentModel<D>, AbstractComponentModel<D>>) unmarshaller.createLoader( getClass() );
  }

  @Override
  public String execute() {
    loader.apply( getNode(), this );
    return super.execute();
  }
  
} /* ENDCLASS */
