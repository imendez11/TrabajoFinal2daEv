/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author S1-PC52
 */
public interface DAO<O,I> { //paso un Objeto y un Integer
   void visualizar(O bean);
   ArrayList<O> findAll(O bean);
   void find(I id);
}
