/*
 * generated by Xtext 2.21.0
 */
package de.joneug.mdal.serializer;

import com.google.inject.Inject;
import de.joneug.mdal.mdal.AlExtension;
import de.joneug.mdal.mdal.Document;
import de.joneug.mdal.mdal.Field;
import de.joneug.mdal.mdal.IdRange;
import de.joneug.mdal.mdal.MdalPackage;
import de.joneug.mdal.mdal.Model;
import de.joneug.mdal.mdal.TypeText;
import de.joneug.mdal.services.MdalGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MdalSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MdalGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MdalPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MdalPackage.AL_EXTENSION:
				sequence_AlExtension(context, (AlExtension) semanticObject); 
				return; 
			case MdalPackage.DOCUMENT:
				sequence_Document(context, (Document) semanticObject); 
				return; 
			case MdalPackage.FIELD:
				sequence_Field(context, (Field) semanticObject); 
				return; 
			case MdalPackage.ID_RANGE:
				sequence_IdRange(context, (IdRange) semanticObject); 
				return; 
			case MdalPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case MdalPackage.TYPE_TEXT:
				sequence_TypeText(context, (TypeText) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AlExtension returns AlExtension
	 *
	 * Constraint:
	 *     (
	 *         name=STRING 
	 *         id=STRING? 
	 *         (idRanges+=IdRange idRanges+=IdRange*)? 
	 *         platform=STRING? 
	 *         publisher=STRING? 
	 *         version=STRING? 
	 *         brief=STRING? 
	 *         description=STRING? 
	 *         privacyStatement=STRING? 
	 *         eula=STRING? 
	 *         help=STRING? 
	 *         url=STRING? 
	 *         contextSensitiveHelpUrl=STRING? 
	 *         showMyCode=Bool? 
	 *         runtime=STRING?
	 *     )
	 */
	protected void sequence_AlExtension(ISerializationContext context, AlExtension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Document returns Document
	 *
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_Document(ISerializationContext context, Document semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdalPackage.Literals.DOCUMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdalPackage.Literals.DOCUMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDocumentAccess().getNameSTRINGTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Field returns Field
	 *
	 * Constraint:
	 *     (name=STRING no=INT? description=STRING? type=Type)
	 */
	protected void sequence_Field(ISerializationContext context, Field semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IdRange returns IdRange
	 *
	 * Constraint:
	 *     (min=INT max=INT?)
	 */
	protected void sequence_IdRange(ISerializationContext context, IdRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     alExtensions+=AlExtension+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns TypeText
	 *     TypeText returns TypeText
	 *
	 * Constraint:
	 *     length=INT?
	 */
	protected void sequence_TypeText(ISerializationContext context, TypeText semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}