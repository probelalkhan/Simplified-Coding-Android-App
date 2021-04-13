package net.simplifiedcoding.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import net.simplifiedcoding.SimplifiedCodingApplication
import net.simplifiedcoding.di.DependencyContainer

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout)